package com.lintcode.LeetCode;

import com.lintcode.Utils.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestMedianOfArrays {

    //Test the Merge Sorted Arrays Function
    @Test
    public void testMergeSortedArr1()
    {
        int[] arr1 = new int[]{1,1,2};
        int[] arr2 = new int[]{1,2};
        int[] result = MedianOfArrays.MergeSortedArr(arr1,arr2);
        int[] answer = new int[]{1,1,1,2,2};
        System.out.println("Result: "+Arrays.toString(result));
        System.out.println("Answer: "+Arrays.toString(answer));
        Assert.assertTrue(CommonUtils.compareTwoArrays(answer,result));
    }

    @Test
    public void testMergeSortedArr2()
    {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1,2};
        int[] result = MedianOfArrays.MergeSortedArr(arr1,arr2);
        int[] answer = new int[]{1,2};
        System.out.println("Result: "+Arrays.toString(result));
        System.out.println("Answer: "+Arrays.toString(answer));
        Assert.assertTrue(CommonUtils.compareTwoArrays(answer,result));
    }

    @Test
    public void testMergeSortedArr3()
    {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{1};
        int[] result = MedianOfArrays.MergeSortedArr(arr1,arr2);
        int[] answer = new int[]{1,1};
        System.out.println("Result: "+Arrays.toString(result));
        System.out.println("Answer: "+Arrays.toString(answer));
        Assert.assertTrue(CommonUtils.compareTwoArrays(answer,result));
    }

    @Test
    public void testMergeSortedArr4()
    {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{1,2};
        int[] result = MedianOfArrays.MergeSortedArr(arr1,arr2);
        int[] answer = new int[]{1,1,2,2};
        System.out.println("Result: "+Arrays.toString(result));
        System.out.println("Answer: "+Arrays.toString(answer));
        Assert.assertTrue(CommonUtils.compareTwoArrays(answer,result));
    }

    @Test
    public void testMergeSortedArr5()
    {
        int[] arr1 = new int[]{1,2,5};
        int[] arr2 = new int[]{1,2,4};
        int[] result = MedianOfArrays.MergeSortedArr(arr1,arr2);
        int[] answer = new int[]{1,1,2,2,4,5};
        System.out.println("Result: "+Arrays.toString(result));
        System.out.println("Answer: "+Arrays.toString(answer));
        Assert.assertTrue(CommonUtils.compareTwoArrays(answer,result));
    }

    @Test
    public void testMergeSortedArr6()
    {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};
        int[] result = MedianOfArrays.MergeSortedArr(arr1,arr2);
        int[] answer = new int[]{};
        System.out.println("Result: "+Arrays.toString(result));
        System.out.println("Answer: "+Arrays.toString(answer));
        Assert.assertTrue(CommonUtils.compareTwoArrays(answer,result));
    }

    @Test
    public void testMedianOfArrays1()
    {
        int[] arr1 = new int[]{1,3,5};
        int[] arr2 = new int[]{2,4,6};
        double result = MedianOfArrays.MedianOfTwoSortedArrays(arr1,arr2);
        double answer = 3.5;
        System.out.println("Result: "+(result));
        System.out.println("Answer: "+(answer));
        Assert.assertTrue(result==answer);
    }

    @Test
    public void testMedianOfArrays2()
    {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{2};
        double result = MedianOfArrays.MedianOfTwoSortedArrays(arr1,arr2);
        double answer = 1.5;
        System.out.println("Result: "+(result));
        System.out.println("Answer: "+(answer));
        Assert.assertTrue(result==answer);
    }
}
