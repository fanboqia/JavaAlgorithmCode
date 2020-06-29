package com.lintcode.ByteDance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static boolean testIfValid(Integer[] arr, int n){
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i = 0; i < arr.length - 1; i=i+2){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(arr[i+1]);
                if(map.get(arr[i]).size() == n - 1){
                    return false;
                }
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(arr[i+1]);
                map.put(arr[i],list);
            }
            if(map.containsKey(arr[i+1])){
                map.get(arr[i+1]).add(arr[i]);
               if(map.get(arr[i+1]).size() == n - 1){
                   return false;
               }
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(arr[i]);
                map.put(arr[i+1],list);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "[[1, 2],[1, 3],[2, 4]]";
        List<Integer> list = new LinkedList<Integer>();
        for(char chr : str.toCharArray()){
            if(Character.isDigit(chr)){
                list.add(chr-'0');
            }
        }
        System.out.println(testIfValid(list.toArray(new Integer[]{}),4));
    }
}
