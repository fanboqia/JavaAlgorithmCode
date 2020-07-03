package com.lintcode.HuaWei;

import java.math.BigDecimal;
import java.util.Scanner;

public class SelfProtectNum {

    public static int findSelfContainedNumber(int n){
        int count = 0;
        for(int i = 0; i <= n; i++){
            String num = String.valueOf(i);
            String product = (new BigDecimal(i).multiply(new BigDecimal(i)) + "");
            if(product.endsWith(num)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(findSelfContainedNumber(n));
        }
        sc.close();
    }

}
