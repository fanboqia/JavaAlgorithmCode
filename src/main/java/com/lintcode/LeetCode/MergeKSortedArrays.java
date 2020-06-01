package com.lintcode.LeetCode;

import java.util.*;

//Question : Given k sorted arrays, merge them into a single sorted array.
public class MergeKSortedArrays {

    //space complexity O(kn)
    //time complexity O((kn)log(kn))
    public static List<Integer> merge(int[][] arr){
        if(arr == null || arr.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                list.add(arr[i][j]);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-02;
            }
        });
        return list;
    }

    class QueueNode implements Comparable<QueueNode>{

        int array,index,value;

        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            if(o.value > value) return -1;
            //small to big
            if(o.value < value) return 1;
            return 0;
        }
    }

    //space complexity O(kn)
    //time complexity O((kn)log(k))
    public int[] mergeWithPQ(int[][] arr){
        if(arr == null || arr.length == 0) return new int[]{};
        PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
        //push the first element in each arr to the priority queue
        int size = 0;
        for(int i = 0; i < arr.length; i++){
            size += arr[i].length;
            pq.add(new QueueNode(i,0,arr[i][0]));
        }
        int[] result = new int[size];
        //extract the least integer every time
        int i = 0;
        while(!pq.isEmpty()){
            QueueNode node = pq.poll();
            int index = node.index;
            int newIndex = index + 1;
            result[i++]= arr[node.array][index];
            if(newIndex < arr[node.array].length){
                pq.add(new QueueNode(node.array,newIndex,arr[node.array][newIndex]));
            }
        }
        return result;
    }

    public static void main(String[] args){
        //System.out.println(Arrays.toString(merge(new int[][]{{1,2,3},{1,1,1},{0,5,7}}).toArray()));
        System.out.println(Arrays.toString(new MergeKSortedArrays().mergeWithPQ(new int[][]{{1,2,3},{1,1,1},{0,5,7}})));
    }
}
