package com.lintcode;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums.length == 0){
            return -1;
        }
        return search(nums,0,nums.length,target);
    }

    public static int search(int[] nums, int i, int j, int target){
        if(i > j){
            return -1;
        }
        int index = (i + j)/2;
        if(target == nums[index]){
            //find previous same numbers
            int k = index;
            while(k >= 1 && nums[k-1] == target){
                k--;
            }
            return k;
        }
        if(target > nums[index]){
            return search(nums,index+1,j,target);
        }
        if(target < nums[index]){
            return search(nums,i,index-1,target);
        }
        return -1;
    }
}
