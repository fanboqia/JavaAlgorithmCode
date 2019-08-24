package com.lintcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestMergeSortedArr {

    @Test
    public void testMergeSortedArr1(){
        int[] A = new int[]{1,2,3,0,0};
        MergeSortedArr.mergeSortedArray(A,3, new int[]{4,5},2);
    }

    @Test
    public void testMergeSortedArr(){
        int[] C = new int[]{1,2,5,0,0};
        MergeSortedArr.mergeSortedArray(C,3, new int[]{3,4},2);
        System.out.println(Arrays.toString(C));
    }

    @Test
    public void testMergeSortedArr2(){
        int[] C = new int[]{1,1,5,0,0};
        MergeSortedArr.mergeSortedArray(C,3, new int[]{3,4},2);
        System.out.println(Arrays.toString(C));
    }

    @Test
    public void testMergeSortedArr3(){
        int[] C = new int[2];
        MergeSortedArr.mergeSortedArray(C,0, new int[]{3,4},2);
        System.out.println(Arrays.toString(C));
    }

    @Test
    public void testMergeSortedArr4(){
        int[] C = new int[]{4,5,5,0,0};
        MergeSortedArr.mergeSortedArray(C,3, new int[]{3,4},2);
        System.out.println(Arrays.toString(C));
    }

}
