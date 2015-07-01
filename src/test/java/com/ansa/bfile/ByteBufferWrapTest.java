package com.ansa.bfile;

import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBufferWrapTest {

    @Test
    public void normal() {
        String test = "123\n124\n1234";
        ByteBuffer byteBuffer = ByteBuffer.wrap(test.getBytes());
        ByteBufferWrap byteBufferWrap = new ByteBufferWrap(byteBuffer);
        Assert.assertTrue(byteBufferWrap.hashNext());
        Assert.assertEquals("123", byteBufferWrap.readLine());
        Assert.assertTrue(byteBufferWrap.hashNext());
        Assert.assertEquals("124", byteBufferWrap.readLine());
        Assert.assertTrue(byteBufferWrap.hashNext());
        Assert.assertEquals("1234", byteBufferWrap.readLine());
        Assert.assertFalse(byteBufferWrap.hashNext());
    }
}
