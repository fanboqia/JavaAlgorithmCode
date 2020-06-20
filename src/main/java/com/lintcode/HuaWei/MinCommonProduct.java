package com.lintcode.HuaWei;

import java.util.Scanner;

public class MinCommonProduct {

    public static int findMinCommonProduct(int a, int b){
        if(a < 0 || b < 0) { return -1;}
        if(a == b){ return a;}
        if(a > b && a%b == 0){
            return a;
        }
        if(a < b && b%a == 0){
            return b;
        }
        return a*b / gcd2(a,b);
    }

    //辗转相除法递归
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

    //辗转相除法迭代
    public static int gcd2(int a, int b){
        if(a == b){return 1;}
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        int c = 0;
        while(b != 0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(findMinCommonProduct(a,b));
        }
    }
}
