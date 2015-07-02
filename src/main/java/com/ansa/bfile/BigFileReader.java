package com.ansa.bfile;

import java.io.RandomAccessFile;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class BigFileReader implements Runnable{

    private static final int megabyte = 1024 * 1024;

    private BlockingQueue<ByteBufferWrap> blockingQueue;
    private RandomAccessFile file;
    private Processor processor;

    public BigFileReader(BlockingQueue<ByteBufferWrap> queue, RandomAccessFile file, Processor processor){
        this.blockingQueue = queue;
        this.file = file;
        this.processor = processor;
    }


    @Override
    public void run() {
        FileChunkedReader reader = new FileChunkedReader(file, 5);
        while (reader.hasNext()){
            FileChunk fileChunk = reader.next();
            ByteBufferWrap wrap = new ByteBufferWrap(fileChunk.getBuffer());

            try {
                blockingQueue.put(wrap);
                System.out.println("added chunk");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Load is complete");
        processor.loadIsComplete();
    }
}
