package com.lintcode.HuaWei;

import java.math.BigInteger;
import java.util.Scanner;


public class MaxCommonSubString {

    //最长公共子串
    public static int findMaxCommonSubString(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int[][] mat = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    mat[i][j] = 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(i > 0 && j > 0 && mat[i][j] == 1){
                    mat[i][j] = mat[i-1][j-1]+1;
                }
                if(mat[i][j] > max){
                    max = mat[i][j];
                }
            }
        }
        return max;
    }

    //最长公共子序列
    public static int findMaxCommonSubOrder(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int[][] mat = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    mat[i][j] = 1;
                }
            }
        }
        for(int i = 1; i < len1; i++){
            for(int j = 1; j < len2; j++){
                if(mat[i][j] != 0){
                    mat[i][j] = mat[i-1][j-1]+1;
                }else{
                    //比较左边和子序列和右边的子序列
                    mat[i][j] = Math.max(mat[i][j-1],mat[i-1][j]);
                }
            }
        }
        return mat[len1-1][len2-1];
    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str1 = sc.nextLine();
//            String str2 = sc.nextLine();
//            int len = findMaxCommonSubString(str1,str2);
//            System.out.println(len);
//        }
        System.out.println(findMaxCommonSubOrder("123ABCD456","ABE12345D"));
        System.out.println(findMaxCommonSubString("123ABCD456","ABE12345D"));
    }
}
