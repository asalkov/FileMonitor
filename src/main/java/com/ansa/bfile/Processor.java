package com.ansa.bfile;

import java.util.concurrent.BlockingQueue;

public class Processor implements Runnable{
    private java.util.concurrent.BlockingQueue<ByteBufferWrap> blockingQueue;
    private volatile boolean loadComplete = false;

    public Processor(BlockingQueue<ByteBufferWrap> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted() && !loadComplete){

                ByteBufferWrap wrap = blockingQueue.take();
                System.out.println("consuming chunk");

                while (wrap.hashNext()) {
                    System.out.println(wrap.readLine());
                }

            }
        } catch (InterruptedException ex){
            ex.printStackTrace();

        }

    }

    public void loadIsComplete() {
        this.loadComplete = true;

    }
}
