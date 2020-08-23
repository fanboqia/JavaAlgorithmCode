package com.lintcode.InterviewDemo;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static void soft_enough(){
        Object obj1 = new Object();
        SoftReference o2 = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(o2.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(o2.get());
    }

    //-Xms5m -Xmx5m 堆内存不够用了软引用才回收
    public static void soft_not_enough(){
        Object obj1 = new Object();
        SoftReference o2 = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(o2.get());

        obj1 = null;
        try{
            byte[] bytes = new byte[30*1024*1024];
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(obj1);
            System.out.println(o2.get());
        }
    }

    public static void main(String[] args) {
        //soft_enough();
        soft_not_enough();
    }
}
