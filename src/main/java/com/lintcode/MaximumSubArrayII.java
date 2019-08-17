package com.lintcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous.
 * Return the largest sum.
 * Example
 * Example 1:
 *
 * Input:
 * [1, 3, -1, 2, -1, 2]
 * Output:
 * 7
 * Explanation:
 * the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2].
 */
public class MaximumSubArrayII {

    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(List<Integer> nums) {
        // empty
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int len = nums.size();
        int[] a = listIntgerToIntArr(nums);
        int[] aa = listIntgerToIntArr(nums);
        for(int i = 1; i < a.length; i++){
            a[i] = Math.max(a[i-1]+nums.get(i),nums.get(i));
            aa[i] = Math.max(aa[i-1],a[i]);
        }
        int[] b = listIntgerToIntArr(nums);
        int[] bb = listIntgerToIntArr(nums);
        for(int i = len - 2; i >= 0; i--){
            b[i] = Math.max(nums.get(i),b[i+1]+nums.get(i));
            bb[i] = Math.max(bb[i+1],b[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len - 1; i++){
            max = Math.max(bb[i+1] + aa[i],max);
        }
        return max;
    }

    public static int[] listIntgerToIntArr(List<Integer> nums){
        if(nums == null || nums.size() == 0){
            return null;
        }
        int[] arr = new int[nums.size()];
        int i = 0;
        for(Integer num : nums){
            arr[i] = num;
            i++;
        }
        return arr;
    }
}
