package com.lintcode.HuaWei;

import java.util.Map;
import java.util.TreeMap;

public class StringSort {

    public static String sort(String str){
        if(str == null || str.length() == 0) { return ""; }
        Map<Character,String> map = new TreeMap<Character,String>();
        char[] chrs = str.toCharArray();
        for(int i = 0; i < chrs.length; i++){
            if(Character.isLetter(chrs[i])){
                char temp = Character.toLowerCase(chrs[i]);
                if(!map.containsKey(temp)){
                    map.put(temp,String.valueOf(chrs[i]));
                }else{
                    map.put(temp,map.get(temp)+String.valueOf(chrs[i]));
                }
            }
        }
        int i = 0;
        for(Character chr : map.keySet()){
            String temp = map.get(chr);
            char[] temps = temp.toCharArray();
            int j = 0;
            while( j < temps.length ){
                if(!Character.isLetter(chrs[i])){
                    i++;
                }else{
                    chrs[i++] = temps[j++];
                }
            }
        }
        return String.valueOf(chrs);
    }

    public static void main(String[] args){
        System.out.println(sort("BabA?a"));
    }
}
