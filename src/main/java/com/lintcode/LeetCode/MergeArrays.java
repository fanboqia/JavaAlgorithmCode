package com.lintcode.LeetCode;

import java.util.Arrays;

//Question : Given 2 sorted arrays, A and B, where A is long enough to hold the contents of
//A and B, write a function to copy the contents of B into A without using any buffer or
//additional memory.
public class MergeArrays {

    //copy B to A in replacing 0 bits\
    //naive solution
    //time complexity O(nlogn)
    public static int[] mergeArrays(int[] A, int[] B){
        if(A == null || A.length == 0) return A;
        if(B == null || B.length == 0) return A;
        int j = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                A[i] = B[j++];
            }
        }
        Arrays.sort(A);
        return A;
    }

    //double pointer
    //time complexity O(n)
    public static void mergeArraysWithDP(int[] A, int[] B, int aLength, int bLength){
        if(A == null || A.length == 0) return;
        if(B == null || B.length == 0) return;

        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        int mergeIndex = A.length - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            if (A[aIndex] > B[bIndex]) {
                A[mergeIndex--] = A[aIndex--];
            } else {
                A[mergeIndex--] = B[bIndex--];
            }
        }

        while (bIndex >= 0) {
            A[mergeIndex--] = B[bIndex--];
        }
    }

    public static void main(String[] args){
        int[] A = new int[]{1,2,3,0,0,0};
        MergeArrays.mergeArraysWithDP(A,new int[]{2,4,6},3,3);
        System.out.println(Arrays.toString(A));
    }
}
