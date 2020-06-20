package com.lintcode.HuaWei;

import java.util.Scanner;

public class FourDownFiveUP {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        float s = sc.nextFloat();
        double base = Math.floor(s);
        if(s - base >= 0.5){
            System.out.println((int)(base+1));
        }else{
            System.out.println((int)(base));
        }

    }
}
