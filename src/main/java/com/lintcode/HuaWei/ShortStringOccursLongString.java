package com.lintcode.HuaWei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//判断短字符串中的所有字符是否在长字符串中全部出现
public class ShortStringOccursLongString {

    //我的解法
    public static boolean IsAllCharExist(String pShortString,String pLongString){
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        for(int i = 0; i < pShortString.length(); i++){
            set1.add(pShortString.charAt(i));
        }
        for(int i = 0; i < pLongString.length(); i++){
            set2.add(pLongString.charAt(i));
        }
        int j = 0;
        for(Character chr : set1){
            if(set2.contains(chr)){
                j++;
            }
        }
        return j == set1.size();
    }

    //桶的思想
    public static boolean isAllCharExist(String shortString, String longString){
        int[] bucket = new int[128];
        for (int i = 0; i < longString.length(); i++)  //桶 统计频率，某个字符出现频率不为0
            bucket[longString.charAt(i)]++;
        for (int i = 0; i < shortString.length(); i++) {  //短字符串各个字符在长字符串各个字符频率情况
            if(bucket[shortString.charAt(i)] == 0)
                return false;
        }
        return true;
    }

    //正则表达式
    public static boolean isAllCharExistRegular(String str1, String str2) {
        //每个str1中的字符是否在str2中出现
        String regex = "[" + str2 + "]";
        int count = 0;
        for (int i = 0; i < str1.length(); i++)//遍历第一个字符串
        {
            String ss = str1.charAt(i) + "";
            if (ss.matches(regex))//如果匹配正则表达式
            {
                count++;//统计满足正则表达式的字符个数
            }
        }
        return count == str1.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strShort = sc.nextLine();
            String strLong = sc.nextLine();
            System.out.println(isAllCharExist(strShort, strLong));
        }
    }
}
