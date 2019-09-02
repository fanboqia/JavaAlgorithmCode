package com.lintcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example
 * Example 1:
 *
 * Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2],
 * Output: [2].
 * Example 2:
 *
 * Input: nums1 = [1, 2], nums2 = [2],
 * Output: [2].
 * Challenge
 * Can you implement it in three different algorithms?
 */
public class ArrayIntersection {

    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null){return nums2;}
        if(nums2 == null){return nums1;}
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            while(i < nums1.length && j < nums2.length && nums1[i] < nums2[j]){
                i++;
            }
            while(i < nums1.length && j < nums2.length && nums1[i] > nums2[j]){
                j++;
            }
            while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] newArr = new int[set.size()];
        int k = 0;
        for(Integer item : set){
            newArr[k++] = item;
        }
        return newArr;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        // write your code here
        if(nums1 == null){return nums2;}
        if(nums2 == null){return nums1;}
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums1);
        for(int i = 0; i < nums2.length; i++){
            int left = 0;
            int right = nums1.length - 1;
            int mid = (left + right)/2;
            int target = nums2[i];
            while(left <= right){
                mid = (left + right)/2;
                if(nums1[mid] < target){
                    left = mid+1;
                }
                if(nums1[mid] > target){
                    right = mid-1;
                }
                if(nums1[mid] == target){
                    set.add(target);
                    break;
                }
            }
        }
        int[] newArr = new int[set.size()];
        int k = 0;
        for(Integer item : set){
            newArr[k++] = item;
        }
        return newArr;
    }
}
