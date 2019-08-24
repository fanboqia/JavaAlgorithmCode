package com.lintcode;

public class MergeSortedArr {

    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int s = m + n;
        int[] C = new int[s];
        int k = 0;
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            while(i < m && A[i] < B[j]){
                C[k++] = A[i++];
            }
            while(j < n && A[i] > B[j]){
                C[k++] = B[j++];
            }
            while(i < m && j < n && A[i] == B[j]){
                C[k++] = A[i++];
                C[k++] = B[j++];
            }
        }
        while(i < m){
            C[k++] = A[i++];
        }
        while(j < n){
            C[k++] = B[j++];
        }
        for(int z = 0; z < s; z++){
            A[z] = C[z];
        }
    }
}
