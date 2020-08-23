package com.lintcode.Baidu;

public class MergeSort {

    public static void merge(int[] arr){
        if(arr == null || arr.length == 0) return;

    }

    private static int[] merge(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[arr1.length+arr2.length];
        while(i < arr1.length && j < arr2.length){
            if(i < arr1.length && j < arr2.length && arr1[i] == arr2[j]){
                res[k++] = arr1[i++];
                res[k++] = arr2[j++];
            }
            if(i < arr1.length && j < arr2.length && arr1[i] < arr2[j]){
                res[k] = arr1[i++];
            }
            if(i < arr1.length && j < arr2.length && arr1[i] > arr2[j]){
                res[k] = arr2[j++];
            }
        }
        while(i < arr1.length){
            res[k++] = arr1[i++];
        }
        while(j < arr2.length){
            res[k++] = arr2[j++];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
