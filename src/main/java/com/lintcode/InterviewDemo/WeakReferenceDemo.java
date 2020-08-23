package com.lintcode.InterviewDemo;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

//弱引用，用完就回收
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        WeakReference o2 = new WeakReference<>(obj1);
        System.out.println(obj1);
        System.out.println(o2.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(o2.get());
    }
}
