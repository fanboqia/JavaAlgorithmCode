package com.lintcode.InterviewDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7,()->{
            System.out.println("人到齐了！");
        });
        for(int i = 1; i <= 7; i++){
            final int temp = i;
            new Thread(()->{
                System.out.println("第"+temp+"个人到了！");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
