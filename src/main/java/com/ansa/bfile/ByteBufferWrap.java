package com.ansa.bfile;

import java.nio.ByteBuffer;

public class ByteBufferWrap {
    private ByteBuffer byteBuffer;

    public ByteBufferWrap(ByteBuffer byteBuffer){
        this.byteBuffer = byteBuffer;

    }

    public boolean hashNext(){
        return byteBuffer.hasRemaining();
    }

    public String readLine() {
        StringBuffer res = new StringBuffer();

        boolean eol = false;
        byte c = -1;
        while (!eol){
            if (!byteBuffer.hasRemaining()){
                break;
            }

            switch (c = byteBuffer.get()){
                case '\n':
                    eol = true;
                    break;
                case '\r':
                    eol = true;
                    int cur = byteBuffer.position();
                    if (byteBuffer.get() != '\n'){
                        byteBuffer.position(cur);
                    }
                    break;
                default:
                    res.append((char)c);
                    break;
            }

        }
        return res.toString();
    }
}
