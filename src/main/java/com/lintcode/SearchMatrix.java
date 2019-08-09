package com.lintcode;

public class SearchMatrix {

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int colSize = matrix[0].length;
        int rowSize = matrix.length;
        int i = rowSize - 1;
        while(i >= 0){
            int num = matrix[i][0];
            if(target == num){
                return true;
            }
            if(target > num){
                //search in this row
                boolean found = false;
                for(int j = 0; j < colSize; j++){
                    if(matrix[i][j] == target){
                        found = true;
                    }
                }
                return found;
            }
            i--;
        }
        return false;
    }

}
