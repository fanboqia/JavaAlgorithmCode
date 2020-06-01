package com.lintcode.LeetCode;

//Question : Given a matrix, find the path from top left to bottom right with the greatest
//product by moving only down and right.
public class ZeroOneKnapsack {

    //time complexity O(2^n)
    public static int knapsack(int W, int[] weights, int[] values){
        return knapsack(W,weights,values,0);
    }

    private static int knapsack(int W, int[] weights, int[] values, int i){
        if(i == weights.length) return 0;
        if(W-weights[i]<0) return knapsack(W,weights,values,i+1);
        return Math.max(
                //include item
                knapsack(W-weights[i],weights,values,i+1)+values[i],
                //exclude item
                knapsack(W,weights,values,i+1));
    }

    public static int knapsackWithCache(int W, int[] weights, int[] values){
        int[][] cache = new int[weights.length+1][W+1];
        for(int i = 1; i <= weights.length;i++){
            for(int j = 1; j <= W; j++){
                //当前物品超重，不加入，取上一次的
                if(weights[i-1] > j){cache[i][j] = cache[i-1][j];}
                else{
                    //不加入和加入做比较
                    cache[i][j] = Math.max(cache[i-1][j],cache[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return cache[weights.length][W];
    }

    public static void main(String[] args){
        System.out.println(knapsack(5,new int[]{3,2,5},new int[]{6,10,15}));
        System.out.println(knapsackWithCache(5,new int[]{3,2,5},new int[]{6,10,15}));
    }
}
