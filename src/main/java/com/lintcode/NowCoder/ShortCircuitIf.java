package com.lintcode.NowCoder;

public class ShortCircuitIf {
    public static void main(String[] args){
        int i=0;
        int j=0;
        if((++i>0)||(++j>0))
        {
            //打印出i和j的值。
            System.out.println(i);
            System.out.println(j);
        }
    }
}
