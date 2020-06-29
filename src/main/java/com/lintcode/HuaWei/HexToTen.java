package com.lintcode.HuaWei;

import java.math.BigDecimal;
import java.util.Scanner;

public class HexToTen {

        public static int translate(char chr){
            switch(chr){
                case 'A': return 10;
                case 'B': return 11;
                case 'C': return 12;
                case 'D': return 13;
                case 'E': return 14;
                case 'F': return 15;
            }
            return chr - '0';
        }

        //要考虑大数溢出的情况，所以工程中经常要用BigDecimal
        public static void convertHexToTenth(String str){
            if(str == null || str.length() <= 2) { return;}
            str = str.substring(2,str.length());
            BigDecimal sum = new BigDecimal(0);
            for(int i = 0; i < str.length(); i++){
                int power = (str.length() - 1 - i);
                int num = translate(str.charAt(i));
                BigDecimal product = new BigDecimal(1);
                while(power-- > 0){
                    product = product.multiply(BigDecimal.valueOf(16));
                }
                sum = sum.add(product.multiply(BigDecimal.valueOf(num)));
            }
            System.out.println(sum);
        }

        public static void convertHexToTenthWithOverFlow(String str){
            if(str == null || str.length() <= 2) { return;}
            str = str.substring(2,str.length());
            int sum = 0;
            for(int i = 0; i < str.length(); i++){
                int power = (str.length() - 1 - i);
                int num = translate(str.charAt(i));
                int product = 1;
                while(power-- > 0){
                    product = product * 16;
                }
                sum += product * num;
            }
            System.out.println(sum);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                convertHexToTenth(sc.nextLine());
            }
            sc.close();
        }

}
