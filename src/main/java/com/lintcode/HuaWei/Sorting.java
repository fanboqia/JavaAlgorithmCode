package com.lintcode.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

//Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
//Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
//Ihave1nose2hands10fingers
//0112Iaadeeefghhinnnorsssv
public class Sorting {

    //桶排序(知道存储的范围)
    public static String sort(String str){
        char[] chrs = str.toCharArray();
        int[] bucket = new int[128];
        for(int i = 0; i < chrs.length; i++){
            bucket[chrs[i]]++;
        }
        int j = 0;
        for(int i = 0; i < bucket.length; i++){
            while(bucket[i] != 0){
                chrs[j++] = (char)i;
                bucket[i]--;
            }
        }
        return String.valueOf(chrs);
    }

    //Arrays.sort
    public static String sort1(String str){
        char[] ch=str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(sort(sc.nextLine()));
        }
    }
}
