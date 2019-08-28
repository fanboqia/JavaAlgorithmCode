package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCompressString {

    @Test
    public void testCompressString()
    {
        assertTrue( CompressString.compress("a").equals("a"));
    }
    @Test
    public void testCompressString1()
    {
        assertTrue( CompressString.compress("aabbcccd").equals("aabbcccd"));
    }
    @Test
    public void testCompressString2()
    {
        assertTrue( CompressString.compress("aabbccccd").equals("a2b2c4d1"));
    }
}
