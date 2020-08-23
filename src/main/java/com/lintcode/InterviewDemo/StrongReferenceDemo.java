package com.lintcode.InterviewDemo;

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); //强引用
        Object obj2 = obj1;
        obj1 = null;    //回收
        System.gc();
        System.out.println(obj2);   //不影响obj2的强引用
    }
}
