package com.lintcode.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Question : Given a boolean matrix, update it so that if any cell is true, all the cells in that
//row and column are true.
public class ZeroMatrix {

    //time complexity O(row*col)
    //space complexity O(row*col)
    public static void zeroMatrix(boolean[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return;}
        //copy a matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] matrixCopy = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols;j++){
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols;j++){
                //modify based on a copy-matrix
                if(matrixCopy[i][j]){
                    for(int x = 0; x < rows; x++){
                        matrix[x][j] = true;
                    }
                    for(int y = 0; y < cols; y++){
                        matrix[i][y] = true;
                    }

                }
            }
        }
    }

    //time complexity O(row*col)
    //space complexity O(# of true)
    public static void zeroMatrixHashSet(boolean[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return;}
        //copy a matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols;j++){
                if(matrix[i][j]) {
                    set.add(i + "," + j);
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols;j++){
                //modify based on a copy-matrix
                if(set.contains(i+","+j)){
                    for(int x = 0; x < rows; x++){
                        matrix[x][j] = true;
                    }
                    for(int y = 0; y < cols; y++){
                        matrix[i][y] = true;
                    }

                }
            }
        }
    }

    //best answer
    //这个解法的思想就是利用第一列和第一行作为标记，判断其他列行，
    //所以第一步就是先不改变第一列或第一行以便其他位置可以在第一列行标记
    //最后再改变第一列行
    //time complexity O(rows*cols)
    //space complexity O(1)
    public void zeroMatrixBest(boolean[][] matrix) {

        // Verify the input array is nonzero
        if (matrix.length == 0 || matrix[0].length == 0) return;

        // Determine whether the first row or first column is true
        boolean rowZero = false, colZero = false;
        for (boolean i : matrix[0]) {
            rowZero |= i;
        }
        for (boolean[] i : matrix) {
            colZero |= i[0];
        }

        // For each cell not in the first row/column, if it is true, set the
        // cell in the first row/same column and first column/same row to be
        // true
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    matrix[i][0] = true;
                    matrix[0][j] = true;
                }
            }
        }

        // Go through the first column and set each row to true where cell in
        // the first column is true
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = true;
                }
            }
        }

        // Repeat for the rows
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j]) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = true;
                }
            }
        }

        // Set first row/column to true if necessary
        if (rowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = true;
            }
        }

        if (colZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = true;
            }
        }
    }

    //test
    public static void main(String[] args){
        //test1
        boolean[][] matrix = new boolean[][]{{true,false,false},{false,false,false},{false,false,false}};
        zeroMatrixHashSet(matrix);
        //test2
        boolean[][] matrix1 = new boolean[][]{{false,false,false},{false,true,false},{false,false,false}};
        zeroMatrixHashSet(matrix1);
    }
}
