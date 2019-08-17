package com.lintcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestMaximumSubArrayII {

    @Test
    public void testBinarySearch()
    {
        List<Integer> a = Arrays.asList(new Integer[]{1, 3, -1, 2, -1, 2});
        assertTrue( MaximumSubArrayII.maxTwoSubArrays(a)==7);
    }
}
