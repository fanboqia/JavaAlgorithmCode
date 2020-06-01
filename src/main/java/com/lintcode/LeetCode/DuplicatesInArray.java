package com.lintcode.LeetCode;

import java.util.*;

//4. Find Duplicates
//Question : Given an array of integers where each value 1 <= x <= len(array), write a
//function that finds all the duplicates in the array.
public class DuplicatesInArray {

    //HashSet
    //time complexity O(n)
    //space complexity O(k)
    public static Integer[] findDuplicates(int[] arr){
        if(arr == null || arr.length == 0){return new Integer[]{};}
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }else{
                list.add(arr[i]);
            }
        }
        return (Integer[])list.toArray();
    }

    //Counting sort's counting algorithm
    //time complexity O(n)
    //k is the range of input
    //space complexity is O(k)
    public static Integer[] findDuplicatesByCountingArray(int[] arr){
        if(arr == null || arr.length == 0){return new Integer[]{};}
        int[] countArr = new int[arr.length+1];
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(countArr[arr[i]] == 0){
                countArr[arr[i]] = 1;
            }else{
                list.add(arr[i]);
            }
        }
        return (Integer[])list.toArray();
    }

    //Negation Item!
    //time complexity O(n)
    //space complexity O(1)
    //modify same place by negation!
    public static Integer[] findDuplicatesByNegation(int[] arr){
        if(arr == null || arr.length == 0){return new Integer[]{};}
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i])-1;
            //has been modified
            if(arr[index] < 0){
                set.add(Math.abs(arr[index]));
            }else{
                arr[index] = -arr[index];
            }
        }
        //modify back arr
        for(int i = 0; i < arr.length; i++){
            arr[i] = Math.abs(arr[i]);
        }
        return (Integer[])set.toArray();
    }
}
