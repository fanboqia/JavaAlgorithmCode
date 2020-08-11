package com.lintcode.InterviewDemo;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {

    private String lockA;
    private String lockB;



    public void lock(String lockA, String lockB) throws Exception{
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+" 获取 " + lockA);
            //sleep保证2个线程都到这里等待一下
            TimeUnit.SECONDS.sleep(1);
            synchronized(lockB){
                System.out.println(Thread.currentThread().getName()+" 尝试获取 " + lockB);
            }
        }
    }

    //判断死锁
    //jps 查看所有java进程
    //jstack 查看进程下问题，Found 1 deadlock
    public static void main(String[] args){
        DeadLockDemo demo = new DeadLockDemo();
        String lockA = new String("lockA");
        String lockB = new String("lockB");
        new Thread(()->{
            try {
                demo.lock(lockA,lockB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                demo.lock(lockB,lockA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
