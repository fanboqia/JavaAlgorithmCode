package com.lintcode.InterviewDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int number = 1; //A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            //1 判断
            while(this.number != 1){
                c1.await();
            }
            //2 干活
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //修改标志位
            number = 2;
            //3 唤醒
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            //1 判断
            while(this.number != 2){
                c2.await();
            }
            //2 干活
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //修改标志位
            number = 3;
            //3 唤醒
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            //1 判断
            while(this.number != 3){
                c3.await();
            }
            //2 干活
            for(int i = 0; i < 15; i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            //修改标志位
            number = 1;
            //3 唤醒
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

//A打印5次，B打印10次，C打印15次
public class MultiConditionLockDemo {
    public static void main(String[] args) {
        ShareResource data = new ShareResource();
        new Thread(()->{
            for(int i = 0; i < 2; i++){
                data.print5();
            }
        },"A").start();
        new Thread(()->{
            for(int i = 0; i < 2; i++){
                data.print10();
            }
        },"B").start();
        new Thread(()->{
            for(int i = 0; i < 2; i++){
                data.print15();
            }
        },"C").start();
    }
}
