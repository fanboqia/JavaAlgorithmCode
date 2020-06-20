package com.lintcode.AimForOffer;

//不用循环做1+....+N的和
public class GaussianSum {

    //使用尾递归
    public static int Sum_Solution(int n) {
        return Sum_Solution(n,0);
    }

    public static int Sum_Solution(int n, int sum) {
        if(n == 0){
            return sum;
        }else{
            return Sum_Solution(n-1,sum+n);
        }
    }
    public static void main(String[] args){
        System.out.println(Sum_Solution(5));
    }
}
