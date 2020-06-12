package com.lintcode;

import com.lintcode.Basic.QuickSort;

//找到前K个的数
public class TopK {

    //用到快速排序的partition算法
    //思路：partition返回的Index等于k,那么之前的数都是小于它的数，可以返回了
    public static void find(int[] arr, int k){
        if(arr == null || arr.length == 0){return;}
        if(k > arr.length){return;}
        int curK = arr.length - 1;
        while(curK != k){
            if(curK > k){
                curK = QuickSort.partition(arr,0,curK);
            }
            if(curK < k){
                curK = QuickSort.partition(arr,curK,k-1);
            }
        }
        for(int i = 0; i < curK; i++){
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        find(new int[]{4,2,1,3,5},2);
    }
}
