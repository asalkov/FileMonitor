package com.ansa.bfile;

import sun.net.www.http.ChunkedInputStream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public class FileChunkedReader implements Iterator<FileChunk> {
    private RandomAccessFile file;
    private long chunkSize;

    private long currentPosition = 0;

    public FileChunkedReader(RandomAccessFile file, long chunkSize) {
        this.file = file;
        this.chunkSize = chunkSize;
    }


    @Override
    public FileChunk next() {
        try {
            long start = currentPosition;
            currentPosition += chunkSize;
            if (currentPosition > file.length()) {
                currentPosition = file.length();
            }
            file.seek(currentPosition);
            file.readLine();
            long end = file.getFilePointer();
            currentPosition = end;
            return new FileChunk(file.getChannel(), start, end);
        } catch (IOException e) {
            return null;
        }

    }

    @Override
    public boolean hasNext() {
        try {
            return currentPosition < file.length();
        } catch (IOException e) {
            return false;
        }
    }
}
