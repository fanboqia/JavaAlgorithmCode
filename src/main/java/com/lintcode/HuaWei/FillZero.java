package com.lintcode.HuaWei;

import java.util.Scanner;

public class FillZero {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            for(int i = 0; i < num; i++){
                String str = sc.next();
                if(str.length() < 8){
                    str = str+"00000000";
                    str = str.substring(0,8);
                    System.out.println(str);
                }else if(str.length() > 8){
                    int temp = str.length() / 8;
                    int mod = str.length() % 8;
                    for(int j = 0; j < temp; j++){
                        System.out.println(str.substring(j*8,(j+1)*8));
                    }
                    if(mod != 0){
                        str = str.substring(str.length() - mod)+"00000000";
                        str = str.substring(0,8);
                        System.out.println(str);
                    }
                }else {
                    System.out.println(str);
                }
            }
        }
        sc.close();
    }
}
