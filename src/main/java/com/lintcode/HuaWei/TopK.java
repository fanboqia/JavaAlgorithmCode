package com.lintcode.HuaWei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//最大堆实现TOPK
public class TopK {

      //TOPK最小
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int len=sc.nextInt();
//            int k=sc.nextInt();
//            int[] nums=new int[len];
//            for (int i = 0; i <len ; i++) {
//                nums[i]=sc.nextInt();
//
//            }
//            //最大堆
//            PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2-o1;
//
//                }
//            });
//            //先加入K个数，再不断吐出最大的数，比这个数小的就替换
//            for (int i = 0; i <len ; i++) {
//                if(i<k){
//                    q.offer(nums[i]);
//                }else{
//                    if(nums[i]<q.peek()){
//                        q.poll();
//                        q.offer(nums[i]);
//                    }
//                }
//            }
//            ArrayList<Integer> list=new ArrayList<>();
//            while(!q.isEmpty()){
//                list.add(q.poll());
//            }
//            for(int i=list.size()-1;i>0;i--){//按顺序
//                System.out.print(list.get(i)+" ");
//            }
//            System.out.println(list.get(0));//有多个测试用例 最后换行 代表结束
//        }
//    }

    //TOPK最大
    //nlogk
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len=sc.nextInt();
            int k=sc.nextInt();
            int[] nums=new int[len];
            for (int i = 0; i <len ; i++) {
                nums[i]=sc.nextInt();

            }
            //最大堆
            PriorityQueue<Integer> q=new PriorityQueue<>();
            //先加入K个数，再不断吐出最大的数，比这个数小的就替换
            for (int i = 0; i <len ; i++) {
                if(i<k){
                    q.offer(nums[i]);
                }else{
                    if(nums[i]>q.peek()){
                        q.poll();
                        q.offer(nums[i]);
                    }
                }
            }
            ArrayList<Integer> list=new ArrayList<>();
            while(!q.isEmpty()){
                list.add(q.poll());
            }
            for(int i=list.size()-1;i>0;i--){//按顺序
                System.out.print(list.get(i)+" ");
            }
            System.out.println(list.get(0));//有多个测试用例 最后换行 代表结束
        }
    }

}
