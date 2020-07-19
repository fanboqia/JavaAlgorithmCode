package com.lintcode.Parallel;

import java.util.Vector;

public class ProConMain {
    public static void main(String[] args){
        Vector<Integer> vector = new Vector<Integer>();
        Thread c = new Thread(new Consumer(vector,4));
        Thread p = new Thread(new Producer(vector,4));
        c.start();
        p.start();
    }
}
