package com.lintcode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Question : Write a function that returns all permutations of a given list.
public class Permutations {

    //time complexity O(n*n!)  * n!是多少个排列组合, n是执行n次才能print一个结果
    public static <T> List<T[]> permute(T[] arr){
        List<T[]> result = new LinkedList<T[]>();
        permu(result, arr,0,arr.length-1);
        return result;
    }

    private static <T> void permu(List<T[]> result, T[] arr, int l, int r){
        if(l > r){
            //注意这个arr要深拷贝一份，防止引用修改
            result.add(arr.clone());
        }else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permu(result, arr, l + 1, r);
                swap(arr, l, i);
            }
        }
    }

    private static <T> void swap(T[] arr, int i, int j){
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //字符串写法
    public ArrayList<String> stringPermutations(String s) {
        ArrayList<String> result = new ArrayList<String>();
        stringPermutations("", s, result);
        return result;
    }

    private void stringPermutations(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), results);
            }
        }
    }

    public static void main(String[] args){
        Integer[] test = new Integer[]{1,2,3};
        List<Integer[]> result = permute(test);
        for(Integer[] item : result){
            System.out.println(Arrays.toString(item));
        }
    }
}
