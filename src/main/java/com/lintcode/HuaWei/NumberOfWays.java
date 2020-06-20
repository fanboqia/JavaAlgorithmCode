package com.lintcode.HuaWei;

import java.util.Scanner;

public class NumberOfWays {

    //Recursion
    public static int findWays(int n, int m){
        if(n == 0 || m == 0){
            return 1;
        }else{
            return findWays(n-1,m) + findWays(n,m-1);
        }
    }

    //DP
    public static int findWays2(int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(findWays2(a,b));
        }
        sc.close();
    }

}
