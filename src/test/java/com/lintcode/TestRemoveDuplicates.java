package com.lintcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestRemoveDuplicates {

    //@Test
    public void testRemoveDuplicates(){
        assertTrue( RemoveDuplicates.removeDuplicates(new int[]{1,1,2}) == 2);
        assertTrue( RemoveDuplicates.removeDuplicates(new int[]{1,1,2,2}) == 2);
        assertTrue( RemoveDuplicates.removeDuplicates(new int[]{1,1,2,2,3}) == 3);
        assertTrue( RemoveDuplicates.removeDuplicates(new int[]{1,1,2,2,3,10}) == 4);
    }

    //@Test
    public void testPrintDuplicates(){
        int[] arr = new int[]{1,1,2,2,3,10,10};
        int size = RemoveDuplicates.removeDuplicates(arr);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,size)));
    }

    @Test
    public void testRemoveDuplicatesToTwice(){
        int[] arr = new int[]{1,1,2,2,2,3,10,10,10};
        int size = RemoveDuplicates.removeDuplicatesToTwice(arr);
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,size)));
    }

}
