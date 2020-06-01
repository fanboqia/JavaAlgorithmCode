package com.lintcode.LeetCode;

import com.lintcode.Utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestConsecutiveArray {

    @Test
    public void testConsecutiveArray1()
    {
        int[] arr1 = new int[]{1,1,2};
        int result = ConsecutiveArray.findConsecutiveArrayBySorting(arr1);
        int answer = 2;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }

    @Test
    public void testConsecutiveArray2()
    {
        int[] arr1 = new int[]{2,1,1};
        int result = ConsecutiveArray.findConsecutiveArrayBySorting(arr1);
        int answer = 2;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }

    @Test
    public void testConsecutiveArray3()
    {
        int[] arr1 = new int[]{2,1,1,2};
        int result = ConsecutiveArray.findConsecutiveArrayBySorting(arr1);
        int answer = 2;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }

    @Test
    public void testConsecutiveArray4()
    {
        int[] arr1 = new int[]{3,1,1,2};
        int result = ConsecutiveArray.findConsecutiveArrayBySorting(arr1);
        int answer = 3;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }

    @Test
    public void testConsecutiveArray5()
    {
        int[] arr1 = new int[]{3,1,1,2,5,7,6,8};
        int result = ConsecutiveArray.findConsecutiveArrayBySorting(arr1);
        int answer = 4;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }

    @Test
    public void testConsecutiveArray6()
    {
        int[] arr1 = new int[]{3,1,1,2,5,7,6,8};
        int result = ConsecutiveArray.findConsecutiveArrayByHashSet(arr1);
        int answer = 4;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }

    @Test
    public void testConsecutiveArray7()
    {
        int[] arr1 = new int[]{1,3,5,7};
        int result = ConsecutiveArray.findConsecutiveArrayByHashSet(arr1);
        int answer = 1;
        System.out.println("Result: "+result);
        System.out.println("Answer: "+answer);
        Assert.assertTrue(answer==result);
    }
}
