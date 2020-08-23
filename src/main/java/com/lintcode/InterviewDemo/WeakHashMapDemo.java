package com.lintcode.InterviewDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void hashmap_demo(){
        Map<String,String> map = new HashMap<String,String>();
        String key = "1";
        String value = "1";
        map.put(key,value);

        System.out.println(map);
        System.out.println(map.size());

        key = null;
        System.out.println(map);
        System.out.println(map.size());

        System.gc();
        System.out.println(map);
        System.out.println(map.size());
    }

    public static void weak_hashmap_demo(){
        Map<String,String> map = new WeakHashMap<String,String>();
        String key = "1";
        String value = "1";
        map.put(key,value);

        System.out.println(map);
        System.out.println(map.size());

        key = null;
        System.out.println(map);
        System.out.println(map.size());

        System.gc();
        System.out.println(map);
        System.out.println(map.size());
    }

    public static void main(String[] args) {
        hashmap_demo();
        System.out.println("==================");
        weak_hashmap_demo();
    }
}
