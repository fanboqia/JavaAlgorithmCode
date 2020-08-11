package com.lintcode.InterviewDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//两个线程交替打印
public class ProducerAndConsumerWithLock {
     private final static ReentrantLock lock = new ReentrantLock();
     private Condition condition = lock.newCondition();
     private int number = 0;

     public void produce(){
         lock.lock();
         try{
             //判断
             while(this.number != 0){
                 condition.await();
             }
             //干活
             this.number++;
             System.out.println(Thread.currentThread().getName()+" "+this.number);
             //通知唤醒
             condition.signalAll();
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
     }

    public void consume(){
        lock.lock();
        try{
            //判断
            while(this.number == 0){
                condition.await();
            }
            //干活
            this.number--;
            System.out.println(Thread.currentThread().getName()+" "+this.number);
            //通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerWithLock obj = new ProducerAndConsumerWithLock();
        new Thread(()->{
            for(int i = 0; i < 3; i++){
                obj.produce();
            }
        },"A").start();
        new Thread(()->{
            for(int i = 0; i < 3; i++){
                obj.consume();
            }
        },"B").start();
    }
}
