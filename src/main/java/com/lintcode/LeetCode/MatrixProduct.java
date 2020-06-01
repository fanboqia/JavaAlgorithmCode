package com.lintcode.LeetCode;

//Question: Given a matrix, find the path from top left to bottom right with the greatest
//product by moving only down and right.
public class MatrixProduct {

    //brute force exponential; however with memorization is O(mn)
    public static int matrixProduct(int[][] matrix){
        return matrixProduct(matrix,0,0,1);
    }

    private static int matrixProduct(int [][] matrix, int i, int j, int product){
        if(i >= matrix.length || j >= matrix[0].length) return product;
        product *= matrix[i][j];
        return Math.max(
                //down
                matrixProduct(matrix,i+1,j,product),
                //right
                matrixProduct(matrix,i,j+1,product));
    }

    //dynamic programming
    public static int matrixProductDP(int [][]matrix){
        if(matrix.length == 0 || matrix[0].length == 0){return 0;}
        int[][] maxCache = new int[matrix.length][matrix[0].length];
        int[][] minCache = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int maxVal = Integer.MIN_VALUE;
                int minVal = Integer.MAX_VALUE;
                if(i == 0 && j == 0){
                    maxVal = matrix[0][0];
                    minVal = matrix[0][0];
                }
                //current val * val from above
                if(i > 0){
                    int tempMax = Math.max(maxCache[i-1][j]*matrix[i][j],minCache[i-1][j]*matrix[i][j]);
                    maxVal = Math.max(tempMax,maxVal);
                    int tempMin = Math.min(maxCache[i-1][j]*matrix[i][j],minCache[i-1][j]*matrix[i][j]);
                    minVal = Math.min(tempMin,minVal);
                }
                //current val * val from left
                if(j > 0){
                    int tempMax = Math.max(maxCache[i][j-1]*matrix[i][j],minCache[i][j-1]*matrix[i][j]);
                    maxVal = Math.max(tempMax,maxVal);
                    int tempMin = Math.min(maxCache[i][j-1]*matrix[i][j],minCache[i][j-1]*matrix[i][j]);
                    minVal = Math.min(tempMin,minVal);
                }
                maxCache[i][j] = maxVal;
                minCache[i][j] = minVal;
            }
        }
        return maxCache[matrix.length-1][matrix[0].length-1];
    }

    public static void main(String[] args){
       //System.out.println(matrixProduct(new int[][]{{-1,2,3},{4,5,-6},{7,8,9}}));
        System.out.println(matrixProductDP(new int[][]{{-1,2,3},{4,5,-6},{7,8,9}}));
    }
}
