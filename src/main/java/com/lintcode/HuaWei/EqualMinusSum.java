package com.lintcode.HuaWei;

import java.util.Scanner;

//等差数列公式
//Sn=a1*n+n*(n-1)*d/2
public class EqualMinusSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int temp;
            if((temp = sc.nextInt()) < 1){
                System.out.println(-1);
            }
            int start = 2;
            int sum = start * temp + temp * (temp - 1) * 3/2;
            System.out.println(sum);
        }
        sc.close();
    }

}
