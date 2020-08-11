package com.lintcode.InterviewDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    //抛异常
    public void testAdd(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        queue.add(3);
        queue.add(3);
        queue.add(3);
        queue.add(3);
    }

    public void testRemove(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        queue.remove();
    }

    //return false
    public void testOffer(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
    }

    //阻塞
    public void testPut(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        try {
            queue.put(2);
            queue.put(1);
            queue.put(1);
            queue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //阻塞等待超时
    public void testOfferTimeOut(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        try {
            queue.offer(2,2L, TimeUnit.SECONDS);
            queue.offer(2,2L, TimeUnit.SECONDS);
            queue.offer(2,2L, TimeUnit.SECONDS);
            queue.offer(2,2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testSynchronousQueue(){
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put 1");
                queue.put(1);
                System.out.println(Thread.currentThread().getName()+" put 2");
                queue.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" get " + queue.take());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" get " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

    public static void main(String[] args) {
        BlockingQueueDemo demo = new BlockingQueueDemo();
        demo.testSynchronousQueue();
    }
}
