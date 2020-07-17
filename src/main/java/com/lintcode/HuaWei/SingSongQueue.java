package com.lintcode.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class SingSongQueue {
    public static int numOut(int len, int[] nums){
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        Arrays.fill(up,1);
        Arrays.fill(down,1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i ; j++){
                if(nums[j] < nums[i] && up[j] + 1 > up[i]){
                    up[i] = up[j] + 1;
                }
            }
        }
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j] < nums[i] && down[j] + 1 > down[i]){
                    down[i] = down[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(up[i]+down[i] > max){
                max = up[i]+down[i];
            }
        }
        return nums.length - max + 1;
    }
    public static void main(String[] args){
        //8
        //186 186 150 200 160 130 197 200
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for(int i = 0; i < len; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(numOut(len,arr));
        }
        sc.close();
    }
}
