package com.lintcode.Basic;

import java.util.Arrays;

public class CountingSort {

    //N: 原数组长度
    //M: 数组范围长度
    //时间复杂度O(N+M)
    //空间复杂度O(M)
    public static void sort(int[] arr){
        //找出数组范围的最大值和最小值
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //构造统计频率数组
        int range = max - min + 1;
        int[] countArray = new int[range];
        for(int i = 0; i < arr.length; i++){
            countArray[arr[i]-min]++;
        }
        //构造前缀和频率统计数组
        for(int i = 1; i < countArray.length; i++){
            countArray[i] = countArray[i-1] + countArray[i];
        }
        //填充到新的数组中
        int[] sortedArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            //拿到偏移下标: arr[i]-min
            countArray[arr[i] - min]--;
            sortedArray[countArray[arr[i] - min]] = arr[i];
        }
        System.out.println(Arrays.toString(sortedArray));
    }

    public static void main(String[] args) {
        sort(new int[]{6,7,3,5,1});
    }
}
