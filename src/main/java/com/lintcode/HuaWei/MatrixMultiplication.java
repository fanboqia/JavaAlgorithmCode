package com.lintcode.HuaWei;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void MatrixMultiplication(int[][] mat1, int[][] mat2){
        int[][] mat = new int[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++){
            for(int j = 0; j < mat2[0].length; j++){
                int sum = 0;
                for(int k = 0; k < mat1[i].length; k++){
                    sum+=mat1[i][k]*mat2[k][j];
                }
                mat[i][j] = sum;
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int row = sc.nextInt();
            int col_row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();
            int[][] mat1 = new int[row][col_row];
            int[][] mat2 = new int[col_row][col];
            for (int i = 0; i < row; i++) {
                String temp = sc.nextLine();
                String[] nums = temp.split(" ");
                for (int j = 0; j < col_row; j++) {
                    mat1[i][j] = Integer.valueOf(nums[j]);
                }
            }
            for (int i = 0; i < col_row; i++) {
                String temp = sc.nextLine();
                String[] nums = temp.split(" ");
                for (int j = 0; j < col; j++) {
                    mat2[i][j] = Integer.valueOf(nums[j]);
                }
            }
            MatrixMultiplication(mat1, mat2);
        }
        sc.close();
    }

}
