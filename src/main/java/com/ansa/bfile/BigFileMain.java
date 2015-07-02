package com.ansa.bfile;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BigFileMain {



    public static void main(String[] args){
        BlockingQueue<ByteBufferWrap> queue = new ArrayBlockingQueue<>(2);

        try {
            RandomAccessFile file = new RandomAccessFile("data/testData", "r");


            Processor processor = new Processor(queue);
            BigFileReader reader = new BigFileReader(queue, file, processor);

            Thread th = new Thread(reader);
            th.start();

            Thread th1 = new Thread(processor);
            th1.start();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
