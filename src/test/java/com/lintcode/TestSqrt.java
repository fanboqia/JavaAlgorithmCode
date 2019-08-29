package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSqrt {

    @Test
    public void testSqrt1()
    {
        assertTrue( Sqrt.sqrt(4187) == 64);
    }

    @Test
    public void testSqrt2()
    {
        assertTrue( Sqrt.sqrt(65536) == 256);
    }
}
