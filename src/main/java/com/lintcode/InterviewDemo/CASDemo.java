package com.lintcode.InterviewDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(5);
        //5 = 5 -> set 2019
        System.out.println(a.compareAndSet(5,2019));
        //2019 != 5
        System.out.println(a.compareAndSet(5,1000));
    }
}
