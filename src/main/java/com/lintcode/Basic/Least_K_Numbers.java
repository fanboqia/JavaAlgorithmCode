package com.lintcode.Basic;

import java.util.*;

public class Least_K_Numbers {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int i = 0; i < input.length; i++){
            if(queue.size() < k){
                queue.offer(input[i]);
            }else{
                if(queue.peek() > input[i]){
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>(queue);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4).toArray()));
    }
}
