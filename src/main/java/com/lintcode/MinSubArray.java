package com.lintcode;

import java.util.List;

public class MinSubArray {

    public static int minSubArray(List<Integer> nums) {
        if(nums == null){
            return Integer.MIN_VALUE;
        }
        Integer prevMin = 0;
        Integer globalMin = Integer.MAX_VALUE;
        for(Integer num : nums){
            prevMin = Math.min(prevMin+num,num);
            globalMin = Math.min(prevMin,globalMin);
        }
        return globalMin;
    }
}
