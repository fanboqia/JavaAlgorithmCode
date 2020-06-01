package com.lintcode.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//5. Consecutive Array
//Question : Given an unsorted array, find the length of the longest sequence of
//consecutive numbers in the array.
public class ConsecutiveArray {

    //sort first, then find consecutive array
    //time complexity O(nlogn)
    //space complexity O(1)
    public static int findConsecutiveArrayBySorting(int[] arr){
        if(arr == null || arr.length == 0){return 0;}
        if(arr.length == 1){return 1;}
        //sort
        Arrays.sort(arr);
        //find consecutive array
        int i = 0;
        int j = i + 1;
        int maxLen = 0;
        while(i < arr.length - 1){
            //k is shift value
            int k = 1;
            while(j < arr.length && arr[i] + k == arr[j]){
                k++;
                j++;
            }
            if(k > maxLen){
                maxLen = k;
            }
            i = j;
            j++;
        }
        return maxLen;
    }

    //HashSet contains
    //这个算法的核心就是遍历的过程中，判断当前的数字是否是最小开始的数字，如果是，那么就一直找比他大一个的，如果不是，那么就看下一个数字
    public static int findConsecutiveArrayByHashSet(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        for(int i : arr){
            set.add(i);
        }

        int maxLen = 0;
        for(Integer item : set){
            //if not the leftmost number then skip
            if(set.contains(item-1)){continue;}
            //from the leftmost, continuously add up one by one
            int len = 0;
            while(set.contains(item++)){len++;}
            maxLen = Math.max(len,maxLen);
        }

        return maxLen;
    }
}
