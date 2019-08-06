package com.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestMinSubArray {

    @Test
    public void testMinSubArray(){
        List<Integer> nums = Arrays.asList(new Integer[]{1,-1,-2,1});
        List<Integer> nums1 = Arrays.asList(new Integer[]{1,1});
        assertTrue(MinSubArray.minSubArray(nums)==-3);
        assertTrue(MinSubArray.minSubArray(nums1)==1);
    }
}
