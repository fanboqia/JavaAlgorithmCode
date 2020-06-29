package com.lintcode.Kujiale;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {

    public static int findElementMoreThanHalfTime(int[] arr){
        if(arr == null || arr.length == 0) { return 0; }
        int len = arr.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        for(Integer num : map.keySet()){
            if(map.get(num) > len/2){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,1,1,1,1,2,2,2,2,2};
        System.out.println(findElementMoreThanHalfTime(arr));
    }
}
