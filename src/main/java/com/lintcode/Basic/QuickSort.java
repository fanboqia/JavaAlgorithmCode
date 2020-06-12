package com.lintcode.Basic;

public class QuickSort {

    public static void sort(int[] arr){
        sortRecursion(arr,0,arr.length-1);
        for(int i : arr){System.out.print(i);}
    }

    public static void sortRecursion(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        sortRecursion(arr,start,mid-1);
        sortRecursion(arr,mid+1,end);
    }

    public static int partition(int[] arr, int start, int end){
        int middleValue = arr[start];
        while(start < end){
            while(arr[end] >= middleValue && start < end){
                end--;
            }
            arr[start] = arr[end];
            while(arr[start] <= middleValue && start < end){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = middleValue;
        return start;
    }

    public static void main(String[] args) {
        sort(new int[]{4,2,1,3,5});
    }
}
