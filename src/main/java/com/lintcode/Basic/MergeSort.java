package com.lintcode.Basic;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        sort(arr,start,mid);
        sort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid;
        int k = 0;
        while(i < mid && j <= end){
            if(arr[i] == arr[j]){
                temp[k++] = arr[i++];
                temp[k++] = arr[j++];
            }else if(arr[i] > arr[j]){
                temp[k++] = arr[j++];
            }else{
                temp[k++] = arr[i++];
            }
        }
        while(i < mid){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }
        for(int h = start; h <= end; h++){
            arr[h] = temp[h-start];
        }
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                arr[k++] = arr1[i++];
                arr[k++] = arr2[j++];
            }else if(arr1[i] > arr2[j]){
                arr[k++] = arr2[j++];
            }else{
                arr[k++] = arr1[i++];
            }
        }
        while(i < arr1.length){
            arr[k++] = arr1[i++];
        }
        while(j < arr2.length){
            arr[k++] = arr2[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        sort(new int[]{3,5,6,1,2});
    }
}
