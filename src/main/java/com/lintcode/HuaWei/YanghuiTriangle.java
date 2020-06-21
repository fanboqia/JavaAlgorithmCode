package com.lintcode.HuaWei;

import java.util.Scanner;


//思路：1.找规律，发现，如果用数组表示的话，第1行的1并不是在最左边，而是在第n个元素位置（n代表行号）
//     2.第n行的元素的第一个和最后一个是要提前赋值为1.其他行的元素，除第一个外，按照公式
//      a[i][j]=a[i][j-1]+a[i][j]+a[i][j+1];
//      a[0][n-1]=a[n-1][0]=a[n-1][2*n-2]=1;
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
