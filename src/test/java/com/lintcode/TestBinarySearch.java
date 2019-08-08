package com.lintcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestBinarySearch {

    @Test
    public void testBinarySearch()
    {
        assertTrue( BinarySearch.binarySearch(new int[]{2,2,3,4,5,6,8,13,17,18},17) == 8);
        assertTrue( BinarySearch.binarySearch(new int[]{4,5,9,9,12,13,14,15,15,18},10) == -1);
    }
}
