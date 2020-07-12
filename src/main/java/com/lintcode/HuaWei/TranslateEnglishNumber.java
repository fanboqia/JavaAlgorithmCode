package com.lintcode.HuaWei;

import java.util.Scanner;

public class TranslateEnglishNumber {

    public static String parse(long num){
        String[] arr_ge ={"one","two","three","four","five","six","seven","eight","nine"};
        String[] arr_10_19 ={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
        String[] arr_shi ={"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        if(num == 0){
            return "zero";
        }
        if(num < 0){
            return "error";
        }
        if(num <= 9){
            return arr_ge[(int)num-1];
        }
        if(num >= 10 && num <= 19){
            return arr_10_19[(int)(num-10)];
        }
        if(num >= 20 && num <= 99){
            if(num % 10 == 0){
                return arr_shi[(int)(num/10)-1];
            }else{
                return arr_shi[(int)(num/10)-1] + " " + arr_ge[(int)(num%10)-1];
            }
        }
        if(num >= 100 && num <= 999){
            if(num % 100 == 0){
                return parse(num/100)+" hundred";
            }else{
                return parse(num/100)+" hundred and " + parse(num%100);
            }
        }
        if(num >= 1000 && num <= 999999){
            if(num % 1000 == 0){
                return parse(num/1000)+" thousand";
            }else{
                return parse(num/1000)+" thousand " + parse(num%1000);
            }
        }
        if(num >= 1000000 && num <= 999999999){
            if(num % 1000000 == 0){
                return parse(num/1000000)+" million";
            }else{
                return parse(num/1000000)+" million " + parse(num%1000000);
            }
        }
        if(num >= 1000000000 && num <= 9999999999L){
            if(num % 1000000000 == 0){
                return parse(num/1000000000)+" billion";
            }else{
                return parse(num/1000000000)+" billion " + parse(num%1000000000);
            }
        }
        return "error";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()){
            System.out.println(parse(sc.nextLong()));
        }
        sc.close();
    }
}
