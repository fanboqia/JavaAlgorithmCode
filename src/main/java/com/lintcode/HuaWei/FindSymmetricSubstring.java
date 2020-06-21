package com.lintcode.HuaWei;

import java.util.Scanner;

//枚举所有对称子串
public class FindSymmetricSubstring {

    public static int findMaxLen(String str){
        if(str == null || str.length() == 0) {return 0;}
        char[] chrs = str.toCharArray();
        int max = 0;
        for(int i = 0; i < chrs.length; i++){
            for(int j = i; j < chrs.length; j++){
                boolean found = true;
                for(int k = 0; k <= (j-i)/2; k++){
                    if(k + i < chrs.length && j - k >= 0 && chrs[k+i] != chrs[j-k]){
                        found = false;
                    }
                }
                if(found){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                    }
                }
            }
        }
        return max;
    }

    public static int getNumber(String str){
        int result = 1;
        //将字符串反转
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        //获取所有子串，查看翻转后的字符串是否包含该子串
        for(int i = temp.length(); i >= 1 ;i--){
            //i为子串的长度
            for(int j = 0; j <= temp.length()-i;j++){
                String tempSubString = temp.substring(j,j + i);
                if(str.contains(tempSubString)){
                    return i;
                }
            }
        }
        return result;
    }

    //dynamic programming
    public static int getNumberDP(String str){
        int max = 1;
        //将字符串反转
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        int len = temp.length();

        //回文数，可以反转过来，实际上就是最长公共子串
//        int[][] dp = new int[len][len];
//        for(int i = 0; i < len; i++){
//            for(int j = 0; j < len; j++){
//                if(str.charAt(i) == temp.charAt(j)){
//                    dp[i][j] = 1;
//                }
//            }
//        }
//
//        for(int i = 1; i < len; i++){
//            for(int j = 1; j < len; j++){
//                if(dp[i][j] != 0){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                }
//                if(max < dp[i][j]){
//                    max = dp[i][j];
//                }
//            }
//        }
        int[][] dp = new int[len+1][len+1];
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= len; j++){
                if(str.charAt(i-1) == temp.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(getNumberDP(str));
        }
    }
}
