package com.lintcode.HuaWei;

import java.util.Scanner;

//验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
//
//例如：
//
//1^3=1
//
//2^3=3+5
//
//3^3=7+9+11
//
//4^3=13+15+17+19
public class NikosTheorem {

    public static String GetSequeOddNum(int m){
        int avg = m * m;
        int start = avg - (m-1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(i != 0){
                sb.append("+");
            }
            sb.append(start);
            start += 2;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String sb = GetSequeOddNum(sc.nextInt());
            System.out.println(sb);
        }
    }

}
