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

    public static String findMostCommonSubString(String str1, String str2){
        String maxStr; String minStr; int minLen; int maxLen;
        if(str1.length() >= str2.length()){
            maxStr = str1;
            maxLen = str1.length();
            minStr = str2;
            minLen = str2.length();
        }else{
            maxStr = str2;
            maxLen = str2.length();
            minStr = str1;
            minLen = str1.length();
        }
        int[][] dp = new int[minLen+1][maxLen+1];
        int maxLenTotal = 0;
        for(int i = 1; i <= minLen; i++){
            for(int j = 1; j <= maxLen; j++){
                if(minStr.charAt(i-1) == maxStr.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if(maxLenTotal < dp[i][j]){
                    maxLenTotal = dp[i][j];
                }
            }
        }
        for(int i = 0; i <= minLen; i++){
            for(int j = 0; j <= maxLen; j++){
                if(maxLenTotal == dp[i][j]){
                    return maxStr.substring(j-maxLenTotal,j);
                }
            }
        }
        return null;
    }

    public static void interestingSolution(String str1, String str2){
        String max = str1.length() >= str2.length()?str1:str2;
        String min = str1.length() >= str2.length()?str2:str1;
        int l = 0;
        String s ="";
        for(int i=0;i<min.length();i++){
            for(int j=i+1;j<=min.length();j++){
                String temp = min.substring(i,j);
                if(max.contains(temp) && j-i>l){
                    l=j-i;
                    s=temp;
                }else{
                    break;
                }
            }
        }
        System.out.println(s);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String str01 = "msatgfqpleswalkvowbcjllbmtxdjqtxlxoyrobrnpuctrcowegmyjjmgkzibmbplpslbsfawrqmzeckiwctwizhpkthvqaukxmzhyqbhhjbihzoidheibsrfbzaruhlwoiwlexwoaicikadrhcvevcnwxwsskooedipgftdfcmdpdonvjtzsncuylrbfzstplfsnebivzdyhhbajfokqvscrzobdzgnfkeqfhzpugbekegaiidhervdsgc";
            String str02 = "kicndbvtazczllcipodvlrliqargjayiivkuymrusywvotxycdzscogyejpvfmrldueulwijytocrf";
            String str = findMostCommonSubString(str01,str02);
            System.out.println(str);
        }
    }
}
