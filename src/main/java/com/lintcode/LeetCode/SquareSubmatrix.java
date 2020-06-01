package com.lintcode.LeetCode;


//Question: Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
public class SquareSubmatrix {

    //time complexity O(n^3) -> sub-matrix = 1 + 4 + 9 + 16 + ... = sum of n^2 = n^3
    public static int bruteForce(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return 0;}
        int maxLen = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j]==1) maxLen = Math.max(maxLen,bruteForceSub(matrix,i,j));
            }
        }
        return maxLen;
    }

    private static int bruteForceSub(int[][] matrix, int i, int j){
        if(matrix.length <= i || matrix[0].length <= j) return 0;
        if(matrix[i][j] == 0) return 0;
        return 1 + Math.min(
                Math.min(bruteForceSub(matrix,i+1,j),bruteForceSub(matrix,i,j+1)),
                bruteForceSub(matrix,i+1,j+1));
    }

    //with cache
    public static int bruteForceWithCache(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return 0;}
        int maxLen = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j]==1) maxLen = Math.max(maxLen,bruteForceSubWithCache(matrix,i,j,cache));
            }
        }
        return maxLen;
    }

    private static int bruteForceSubWithCache(int[][] matrix, int i, int j, int[][] cache){
        if(matrix.length <= i || matrix[0].length <= j) return 0;
        if(matrix[i][j] == 0) return 0;
        if(cache[i][j] > 0 ) return cache[i][j];

        cache[i][j] =  1 + Math.min(
                Math.min(bruteForceSubWithCache(matrix,i+1,j,cache),bruteForceSubWithCache(matrix,i,j+1,cache)),
                bruteForceSubWithCache(matrix,i+1,j+1,cache));

        return cache[i][j];
    }

    //dynamic programming
    //time complexity: O(n^2)
    public static int SquareMatrixWithDP(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return 0;}
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0 || j == 0){
                    cache[i][j] = matrix[i][j];
                }else if(matrix[i][j] == 1){
                    //加1是因为自己本身算一个submatrix
                    cache[i][j] = Math.min(Math.min(cache[i][j-1],cache[i-1][j]),cache[i-1][j-1]) + 1;
                }
                if(cache[i][j] > max) max = cache[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(SquareMatrixWithDP(new int[][]{{1,1,1,0},{1,1,1,1},{1,1,0,0}}));
    }
}
