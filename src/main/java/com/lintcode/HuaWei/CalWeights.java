package com.lintcode.HuaWei;

import java.util.*;

public class CalWeights {
    //链接：https://www.nowcoder.com/questionTerminal/f9a4c19050fc477e9e27eb75f3bfd49c
    //来源：牛客网
//    public static int fama(int n, int[] weight, int[] nums){
//        Set<Integer> set = new HashSet<Integer>();
//        for(int i = 0; i <= nums[0]; i++){
//            set.add(weight[0] * i);
//        }
//        for(int i = 1; i < n; i++){
//            List<Integer> list = new ArrayList<Integer>(set);
//            for(int j = 1; j <= nums[i]; j++){
//                for(int k = 0; k < list.size(); k++){
//                    set.add(list.get(k) + j * weight[i]);
//                }
//            }
//        }
//        return set.size();
//    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            int[] weight = new int[n];
//            int[] nums = new int[n];
//            for(int i = 0; i < n; i++){
//                weight[i] = in.nextInt();
//            }
//            for(int i = 0; i < n; i++){
//                nums[i] = in.nextInt();
//            }
//            System.out.println(fama(n, weight, nums));
//        }
//        in.close();
//    }

    public static int fama(int n, int[] weight, int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i <= nums[0]; i++){
            set.add(weight[0] * i);
        }
        for(int i = 1; i < n; i++){
            List<Integer> list = new ArrayList<Integer>(set);
            for(int j = 1; j <= nums[i]; j++){
                for(int k = 0; k < list.size(); k++){
                    set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] weight = new int[n];
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                weight[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < nums.length; i++){
                ArrayList<Integer> inner = new ArrayList<Integer>();
                for(int j = 0; j <= nums[i]; j++){
                    inner.add(weight[i]*j);
                }
                list.add(inner);
            }
            Set<Integer> set = new HashSet<Integer>();
            set.addAll(list.get(0));
            for(int i = 1; i < list.size(); i++){
                List<Integer> temp = new ArrayList<>(set);
                List<Integer> up = list.get(i);
                for(Integer is : temp){
                    for(Integer item : up){
                        set.add(item + is);
                    }
                }
            }
            System.out.println(set.size());
        }
        in.close();
    }
}
