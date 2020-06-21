package com.lintcode.HuaWei;

import java.math.BigDecimal;
import java.util.Scanner;

public class CubicRoot {

    public static double getCubeRoot(double input){
        double temp = input;
        double upper = 0.0;
        double lower = 0.0;
        while(temp > 0.0){
            if(temp*temp*temp > input){
                upper = temp;
                temp /= 2;
            }else{
                lower = temp;
                break;
            }
        }

        double prev = lower;
        double cur = upper;
        while(cur - prev >= 0.01){
            double one = (prev+cur)/2;
            double triple = one * one * one;
            //limit upper bound
            if(triple > input){
                cur = (prev+cur)/2;
            //add lower bound
            }else{
                prev = (prev+cur)/2;
            }
        }
        return new BigDecimal(cur).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double num = sc.nextDouble();
            System.out.println(getCubeRoot(num));
        }
    }

}
