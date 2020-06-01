package com.lintcode.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Question : Given an array, write a function to find any subarray that sums to zero, if one
//exists.
public class ZeroSumSubarray {

    //brute force
    //time complexity O(n^2)
    //space complexity O(n^2)
    public static Integer[] zeroSum(int[] arr){
        if(arr == null || arr.length == 0){return new Integer[]{};}
        for(int i = 0; i < arr.length; i++){
            // if there exists a zero then just return it
            if(arr[i] == 0){
                return new Integer[]{0};
            }
            int sum = arr[i];
            List<Integer> list = new LinkedList<Integer>();
            list.add(arr[i]);
            for(int j = i+1; j < arr.length; j++){
                sum+=arr[j];
                list.add(arr[j]);
                if(sum == 0){
                    return list.toArray(new Integer[]{});
                }
            }
        }
        return new Integer[]{};
    }

    //前缀和算法:寻找index到index的gain为0的range，就是zero sum!!!
    //time complexity: O(n)
    //space complexity: O(n)
    public static int[] zeroSumPrefixSum(int[] arr) {
        if(arr == null || arr.length == 0){return new int[]{};}
        //prefix sum to index
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            Integer oldIndex = map.get(sum+arr[i]);
            if(sum+arr[i] == 0){
                return Arrays.copyOfRange(arr,0,i+1);
            }
            //does not find a zero gain till the last item
            if(oldIndex == null && i == arr.length - 1){
                return null;
            }
            //put
            if(oldIndex == null){
                sum+=arr[i];
                map.put(sum,i);
            //find then return the range of subarray
            }else{
                return Arrays.copyOfRange(arr,oldIndex+1,i+1);
            }
        }
        return null;
    }

    public static void main(String[] args){
        //test brute force
        int[] arr = new int[]{1,2,-5,1,2};
        System.out.println(Arrays.toString(zeroSum(arr)));
        //test prefix sum
        int[] arr1 = new int[]{1,2,2,-2};
        System.out.println(Arrays.toString(zeroSumPrefixSum(arr1)));
    }
}
