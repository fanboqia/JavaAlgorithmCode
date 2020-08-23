package com.lintcode.AimForOffer;

import java.util.LinkedList;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
//添加笔记
//邀请回答
public class FindMinNumber {
    LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        LinkedList<Integer> track = new LinkedList<Integer>();
        print(numbers,track);
        String min = null;
        for(LinkedList<Integer> list : result){
            StringBuilder sb = new StringBuilder();
            for(Integer item : list){
                sb.append(item);
            }
            if(min == null){
                min = sb.toString();
            }else{
                if(min.compareTo(sb.toString()) > 0){
                    min = sb.toString();
                }
            }
        }
        return min;
    }

    public void print(int[] arr, LinkedList<Integer> selected){
        if(selected.size() == arr.length){
            result.add(new LinkedList<Integer>(selected));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(selected.contains(arr[i])){
                continue;
            }
            selected.add(arr[i]);
            print(arr,selected);
            selected.removeLast();
        }
    }

    //所以在这里自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，
    // 比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面
    public class Solution {
        public String PrintMinNumber(int [] numbers) {
            String str = "";
            for (int i=0; i<numbers.length; i++){
                for (int j=i+1; j<numbers.length; j++){
                    int a = Integer.valueOf(numbers[i]+""+numbers[j]);
                    int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                    if (a > b){
                        int t = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = t;
                    }

                }
            }
            for (int i = 0; i < numbers.length; i++) {
                str += String.valueOf(numbers[i]);
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FindMinNumber s = new FindMinNumber();
        s.PrintMinNumber(new int[]{3,32,321});
    }
}
