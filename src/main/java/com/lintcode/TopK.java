package com.lintcode;

import com.lintcode.Basic.QuickSort;

//找到前K个的数
public class TopK {

    //用到快速排序的partition算法
    //思路：partition返回的Index等于k,那么之前的数都是小于它的数，可以返回了
    public static void find(int[] arr, int k){
        findTopK(arr,0,arr.length-1,k);
    }

    //改进后快速排序
    public static void findTopK(int[] arr, int start, int end, int k){
        if(start >= end){
            for(int i = 0; i < k; i++){
                System.out.print(arr[i]+" ");
            }
            return;
        }
        int mid = QuickSort.partition(arr,start,end);
        if(k-1 < mid){
            findTopK(arr,start,mid-1, k);
        }
        if(k-1 > mid){
            findTopK(arr,mid+1,end, k);
        }
        if(k-1 == mid){
            for(int i = 0; i < k; i++){
                System.out.print(arr[i]+" ");
            }
            return;
        }
    }

    public static void main(String[] args) {
        find(new int[]{5,4,3,2,0},5);
    }
}
