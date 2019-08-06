package com.lintcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestMaximumSwap
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMaximumSwap()
    {
        assertTrue( MaximumSwap.maximumSwap(1234) == 4231);
        assertTrue( MaximumSwap.maximumSwap(12) == 21);
        assertTrue( MaximumSwap.maximumSwap(1) == 1);
        assertTrue( MaximumSwap.maximumSwap(2111) == 2111);
        assertTrue( MaximumSwap.maximumSwap(2112) == 2211);
        assertTrue( MaximumSwap.maximumSwap(10) == 10);
        assertTrue( MaximumSwap.maximumSwap(931604) == 961304);
        assertTrue( MaximumSwap.maximumSwap(5656626) == 6656625);
        assertTrue( MaximumSwap.maximumSwap(98386) == 98836);
    }
}
