package com.lintcode.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Question : Given two strings, write a function to determine whether they are anagrams
public class Anagrams {

    //time complexity: O(n)
    public static boolean isAnagram(String str1, String str2){
        if(str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0 ) return false;
        if(str1.length() != str2.length()) return false;
        str1 = str1.toLowerCase(); str2 = str2.toLowerCase();
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        for(Character item : str1.toCharArray()){
            if(!map1.containsKey(item)){
                map1.put(item,1);
            }else{
                map1.put(item,map1.get(item)+1);
            }
        }
        for(Character item : str2.toCharArray()){
            if(!map2.containsKey(item)){
                map2.put(item,1);
            }else{
                map2.put(item,map2.get(item)+1);
            }
        }
        for(Character key : map1.keySet())
            if(!map2.containsKey(key) || map2.get(key) != map1.get(key)) return false;
        return true;
    }

    //因为题目只考虑256个
    public boolean isAnagramAnswer(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        //2^8
        int[] letters = new int[1<<8];

        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c: s2.toCharArray()) {
            letters[c]--;
        }

        for (int i : letters) {
            if (i != 0) return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isAnagram("A2312","a1223"));
    }
}
