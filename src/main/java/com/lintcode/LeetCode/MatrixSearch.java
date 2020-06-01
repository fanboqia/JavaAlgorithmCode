package com.lintcode.LeetCode;

//Question : Given an n x m array where all rows and columns are in sorted order, write a
//function to determine whether the array contains an element x.
public class MatrixSearch {

    //time complexity O(n+m)
    public static boolean search(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = 0;
        if(matrix[row][col] == target) return true;
        //search in row
        while(row + 1 < matrix.length && matrix[row+1][col] <= target){
            if(matrix[row+1][col] == target){
                return true;
            }
            row++;
        }
        //search in col
        while(col + 1 < matrix[row].length && matrix[row][col+1] <= target){
            if(matrix[row][col+1] == target){
                return true;
            }
            col++;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(MatrixSearch.search(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}},5));
    }
}
