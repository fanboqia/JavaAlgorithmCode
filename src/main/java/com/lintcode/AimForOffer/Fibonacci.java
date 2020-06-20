package com.lintcode.AimForOffer;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;

public class Fibonacci {

    //动态规划
    public static int FibonacciDP(int n) {
        if(n <= 1) return n;
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2; i <= n; i++){
            mem[i] = mem[i-1]+mem[i-2];
        }
        return mem[n];
    }

    //递归 O(2^n)
    public static int FibonacciRecursion(int n){
        if(n <= 1) return n;
        else return FibonacciRecursion(n-1) + FibonacciRecursion(n-2);
    }

    //递归 记忆法
    public static int FibonacciRecursionWithMemorization(int n){
        int[] mem = new int[n+1];
        Arrays.fill(mem,-1);
        mem[0] = 0;
        mem[1] = 1;
        return FibonacciRecursionWithMemorization(n,mem);
    }

    public static int FibonacciRecursionWithMemorization(int n,int[] mem){
        if(n <= 1) return n;
        if(mem[n] != -1) return mem[n];
        return mem[n] =  FibonacciRecursion(n-1) + FibonacciRecursion(n-2);
    }

    //尾递归
    private static int Fibonacci(int n,int acc1,int acc2){
        if(n==0) return 0;
        if(n==1) return acc2;
        else     return Fibonacci(n - 1, acc2, acc1 + acc2);
    }

    //节省内存循环
    public int Fibonacci_1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(FibonacciRecursionWithMemorization(10));
    }
}
