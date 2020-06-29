package com.lintcode.HuaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MergekeyValue {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
            int num = sc.nextInt();
            while(num-- > 0){
                Integer key = sc.nextInt();
                Integer val = sc.nextInt();
                try{
                    if(!map.containsKey(key)){
                        map.put(key,val);
                    }else{
                        map.put(key,map.get(key)+val);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
        sc.close();
    }

}
