package com.lintcode.InterviewDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference();

    public void myLock(){
        System.out.println(Thread.currentThread().getName()+" enter!");
        //t1的线程先设置成自己的线程占用，t2进来后发现t1占用就CAS循环等待，直到t1释放
        while(!atomicReference.compareAndSet(null,Thread.currentThread())){

        }
    }

    public void myUnlock(){
        System.out.println(Thread.currentThread().getName()+" exit!");
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }

    public static void main(String[] args) {

        SpinLockDemo demo = new SpinLockDemo();

        new Thread(()->{
            demo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.myUnlock();
        },"t1").start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            demo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.myUnlock();
        },"t2").start();
    }
}
