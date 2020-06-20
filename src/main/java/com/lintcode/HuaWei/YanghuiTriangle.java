package com.lintcode.HuaWei;

import java.util.Scanner;

public class YanghuiTriangle {

    public static int findYanghuiTriangle(int num)
    {
        if(num <= 2){
            return -1;
        }
        int[][] dp = new int[num][2*num-1];
        dp[0][num-1] = 1;
        dp[1][num-1] = 1;
        dp[1][num-2] = 1;
        dp[1][num] = 1;
        for(int i = 2; i < num; i++){
            for(int j = 0; j < 2*num-1; j++){
                if( j - 1 >= 0 && j + 1 < 2*num - 1){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1];
                }else if( j - 1 < 0 ){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j+1];
                }else if( j + 1 >= 2*num - 1 ){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
            }
        }
        for(int j = 0; j < 2*num-1; j++){
            if((dp[num-1][j]&1)==0){
                return j+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(findYanghuiTriangle(num));
        }
    }
}
