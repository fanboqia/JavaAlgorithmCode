package com.lintcode;

public class RemoveDuplicates {

    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        int countDistinct = 0;
        while(i < nums.length){
            while(i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
            nums[countDistinct] = nums[i];
            i++;
            countDistinct++;
        }
        return countDistinct;
    }
}
