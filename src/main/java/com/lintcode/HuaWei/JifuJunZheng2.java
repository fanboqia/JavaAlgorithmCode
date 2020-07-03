package com.lintcode.HuaWei;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JifuJunZheng2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            BigDecimal negCount = new BigDecimal(0);
            BigDecimal posCount = new BigDecimal(0);
            BigDecimal sum = new BigDecimal(0);
            while(sc.hasNext()){
                String num = sc.nextLine();
                if(num.charAt(0) == '-'){
                    negCount = negCount.add(new BigDecimal(1));
                }else{
                    posCount = posCount.add(new BigDecimal(1));
                    sum = sum.add(new BigDecimal(num));
                }
            }
            System.out.println(negCount);
            if(posCount.equals(new BigDecimal(0))){
                System.out.println("0.0");
            }else{
                System.out.println(sum.divide(posCount,1,BigDecimal.ROUND_HALF_UP));
            }
        }
        sc.close();
    }
}
