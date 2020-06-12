package com.lintcode;

public class MajorityNumber {

    //众数：一组数组中，出现次数一半以上的数！
    //核心思路：数据相同则相加，数据不同则抵消，最后剩下的数据就是众数，因为他大于一半的数
    public static Integer majorityNum(int[] arr){
        if(arr == null || arr.length == 0){return null;}

        Integer target = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == target){
                count++;
            }else{
                count--;
                if(count == 0){
                    target = arr[i+1];
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(majorityNum(new int[]{2,3,2,3,2,3,2}));
    }
}
