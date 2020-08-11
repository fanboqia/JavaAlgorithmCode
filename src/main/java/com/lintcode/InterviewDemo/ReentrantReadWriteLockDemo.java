package com.lintcode.InterviewDemo;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    public final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public volatile HashMap<String,String> map = new HashMap<String,String>();

    public void put(String a, String b){
        System.out.println(Thread.currentThread().getName()+" put ("+a+","+b+")");
        rwLock.writeLock().lock();
        try{
            map.put(a,b);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String a){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" get "+ map.get(a));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantReadWriteLockDemo obj = new ReentrantReadWriteLockDemo();

        //写
        for(int i = 0; i < 5; i++){
            final int temp = i;
            new Thread(()->{
                obj.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //读
        for(int i = 0; i < 5; i++){
            final int temp = i;
            new Thread(()->{
                obj.get(temp+"");
            },String.valueOf(i)).start();
        }

    }
}
