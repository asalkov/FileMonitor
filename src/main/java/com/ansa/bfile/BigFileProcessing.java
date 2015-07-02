package com.ansa.bfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class BigFileProcessing {
    private static final int megabyte = 1024 * 1024;
    public static void main(String[] args){

        try {
            RandomAccessFile file = new RandomAccessFile(new File("data/testData"), "r");

            FileChunkedReader reader = new FileChunkedReader(file, megabyte * 5);
            while (reader.hasNext()){
                FileChunk fileChunk = reader.next();
                ByteBufferWrap wrap = new ByteBufferWrap(fileChunk.getBuffer());
                while (wrap.hashNext()) {
                    System.out.println(wrap.readLine());
                }
            }
      } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readLine(){
        return "";
    }
}
