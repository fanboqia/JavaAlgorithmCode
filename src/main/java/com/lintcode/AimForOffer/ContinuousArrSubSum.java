package com.lintcode.AimForOffer;

public class ContinuousArrSubSum {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){return 0;}
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(max < array[i])
                max = array[i];
            if(array[i] + array[i-1] > array[i]){
                array[i] = array[i] + array[i-1];
                if(max < array[i])
                    max = array[i];
            }
        }
        return max;
    }

    public static int FindGreatestSumOfSubArray1(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
        System.out.println(FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9}));
    }
}
