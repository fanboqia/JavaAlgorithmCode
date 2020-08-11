package com.lintcode.InterviewDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

//解决ABA问题
public class AtomicStampedReferenceDemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);

    public static void main(String[] args) {
        System.out.println("=============ABA问题==============");
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try {
                //让当前线程在上面线程执行后执行
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ABA问题："+atomicReference.compareAndSet(100,2019));
        },"t2").start();

        System.out.println("=============解决ABA问题==============");
        new Thread(()->{
            System.out.println("initial stamp: "+atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("t3 modify once stamp: "+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("t3 modify twice stamp: "+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("t4 initial stamp: "+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("解决ABA问题: "+atomicStampedReference.compareAndSet(100,2019,stamp,atomicStampedReference.getStamp()+1));
            System.out.println("t4 final stamp: "+stamp);
        },"t4").start();
    }
}
