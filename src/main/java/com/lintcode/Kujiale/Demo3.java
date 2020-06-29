package com.lintcode.Kujiale;

public class Demo3 {

    public static boolean findElementInMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 ){return false;}
        int row = matrix.length;
        int col = matrix[0].length;
        //从左下角开始找
        int i = row - 1;
        int j = 0;
        while(i >= 0 && j <= col - 1){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                 i--;
            }else if(matrix[i][j] < target){
                 j++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findElementInMatrix(matrix,0));
        System.out.println(findElementInMatrix(matrix,3));
        System.out.println(findElementInMatrix(matrix,9));
        System.out.println(findElementInMatrix(matrix,10));
    }
}
