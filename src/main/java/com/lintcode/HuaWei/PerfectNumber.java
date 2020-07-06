package com.lintcode.HuaWei;

import java.util.Scanner;

public class PerfectNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n=sc.nextInt();
//            int result=0;
//            for(int i = 2; i<n; i++){
//                result=result+count(i);
//            }
//            System.out.println(result);
            System.out.println(findPerfectNumbers(n));
        }
    }

    public static int findPerfectNumbers(int num){
        int count = 0;
        for(int i = 2; i <= num; i++){
            int sum = 1;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    if(i / j == j){
                        sum+=j;
                    }else{
                        sum+= j;
                        sum+= i/j;
                    }
                }
            }
            if(sum == i){
                count++;
            }
        }
        return count;
    }

    private static int count(int i) {
        int sum=1;
        for(int j = 2; j <= (double)Math.sqrt(i); j++){
            if(i%j==0 && i/j!=j)
                sum=sum+j+i/j;
            else if(i%j==0 && i/j==j)
                sum=sum+j;
        }
        if(sum==i)
            return 1;
        else return 0;
    }

}
