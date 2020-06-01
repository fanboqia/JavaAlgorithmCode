package com.lintcode.LeetCode;

//Question : Given a matrix, find the path from top left to bottom right with the greatest
//product by moving only down and right.
public class MedianOfArrays {

    public static int[] MergeSortedArr(int arr1[],int arr2[]){

        //if either one is null or empty, then just return the other one
        if(arr1 == null || arr1.length == 0){ return arr2;}
        if(arr2 == null || arr2.length == 0){ return arr1;}

        //allocation
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        int arrSize = arr1Size + arr2Size;
        int[] arr = new int[arrSize];

        //merge
        int i = 0;
        int j = 0;
        int k = 0;

        //pay attention to the index of i & j
//        while(i < arr1Size && j < arr2Size){
//            while(i < arr1Size && j < arr2Size && arr1[i] < arr2[j]){
//                arr[k++] = arr1[i++];
//            }
//            while(i < arr1Size && j < arr2Size && arr1[i] > arr2[j]){
//                arr[k++] = arr2[j++];
//            }
//            while(i < arr1Size && j < arr2Size && arr1[i] == arr2[j]){
//                arr[k++] = arr1[i++];
//                arr[k++] = arr2[j++];
//            }
//        }

        while(i < arr1Size && j < arr2Size){
            if(i < arr1Size && j < arr2Size && arr1[i] < arr2[j]){
                arr[k++] = arr1[i++];
            }
            if(i < arr1Size && j < arr2Size && arr1[i] >= arr2[j]){
                arr[k++] = arr2[j++];
            }
        }

        //push the rest numbers in arr1 or arr2 to arr
        while(i < arr1Size){
            arr[k++] = arr1[i++];
        }
        while(j < arr2Size){
            arr[k++] = arr2[j++];
        }
        return arr;
    }

    public static double MedianOfTwoSortedArrays(int arr1[], int arr2[]){
        int[] arr = MergeSortedArr(arr1,arr2);
        int size = arr.length;
        if(size == 1){return arr[0];}
        if(size%2 == 1){
            return arr[size/2];
        }else{
            return (arr[size/2]+arr[size/2-1])/2.0;
        }
    }

    //
}
