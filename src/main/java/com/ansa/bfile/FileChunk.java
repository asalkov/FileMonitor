package com.ansa.bfile;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChunk {
    private FileChannel channel;
    private long start;
    private long end;
    public FileChunk(FileChannel channel, long start, long end) {
        this.channel = channel;
        this.start = start;
        this.end = end;
    }

    public ByteBuffer getBuffer(){
        try {
            return channel.map(FileChannel.MapMode.READ_ONLY, start, end-start);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "FileChunk{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
