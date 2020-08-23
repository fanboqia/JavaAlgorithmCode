package com.lintcode.oppo;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class QuickSort {

    public static void sort(int[] arr){
        if(arr == null || arr.length == 0) return;
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        sort(arr,start,mid-1);
        sort(arr,mid+1, end);
    }

    private static int partition(int[] arr, int start, int end){
        int temp = arr[start];
        while(start < end){
            while(start < end && arr[end] >= temp){
                end--;
            }
            arr[start] = arr[end];
            while(start < end && arr[start] <= temp){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,3,4,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
