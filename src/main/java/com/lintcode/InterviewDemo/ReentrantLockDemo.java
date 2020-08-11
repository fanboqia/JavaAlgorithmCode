package com.lintcode.InterviewDemo;

import java.util.concurrent.locks.ReentrantLock;

//synchronized是可重入的，表现在同步方法调用同步方法
class Test implements Runnable{

    public static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

    }
    public synchronized void sendSMS(){
        System.out.println("send SMS");
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println("send Email");
    }

    //加锁和释放锁要配对
    public void get(){
        lock.lock();
        lock.lock();
        try{
            System.out.println("get!");
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println("set!");
        }finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        new Thread(()->{
            new Test().sendSMS();
        },"t1").start();

        new Thread(()->{
            new Test().get();
        },"t2").start();

        new Thread(()->{
            new Test().get();
        },"t3").start();
    }
}
