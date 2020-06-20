package com.lintcode.HuaWei;

import java.util.Scanner;

public class ContinuousBit {

    public static void findContinuousBitOne2(int num){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            String bi = Integer.toBinaryString(input);
            String subs = "1";
            int cnt = 1;
            for(int i=1; i<=bi.length(); i++) {
                if(bi.contains(subs)) {
                    cnt = subs.length();
                    subs += "1";
                }
            }
            System.out.println(cnt);
        }
    }

    public static int findContinuousBitOne(int num){
        int count = 0;
        int prev = 0;
        int cur = 0;
        int max = 0;
        while(num != 0){
            if((num & 1) == 1){
                cur = 1;
                if(prev == cur){
                    count++;
                }else{
                    count = 1;
                }
                prev = cur;
            }else{
                count = 0;
            }
            num = num >> 1;
            if(count > max){
                max = count;
            }
        }
        return max;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(findContinuousBitOne(sc.nextInt()));
        }
    }
}
