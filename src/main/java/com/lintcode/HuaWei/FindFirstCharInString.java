package com.lintcode.HuaWei;

import java.util.LinkedHashMap;
import java.util.Scanner;


//找出字符串中第一个只出现一次的字符
//输入
//asdfasdfo
//输出
//o
public class FindFirstCharInString {
    public static String firstCharInString(String str){
        if(str == null || str.length() == 0 ) { return "-1";}
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        for(int i = 0; i < str.length(); i++){
            Character chr = str.charAt(i);
            if(map.containsKey(chr)){
                map.put(chr,map.get(chr)+1);
            }else{
                map.put(chr,1);;
            }
        }
        for(Character chr : map.keySet()){
            if(map.get(chr) == 1){
                return Character.toString(chr);
            }
        }
        return "-1";
    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String str = sc.nextLine();
//            String result = firstCharInString(str);
//            System.out.println("-1".equals(result) ? -1 : result);
//        }
//        sc.close();
        System.out.println(-12%10);
    }
}
