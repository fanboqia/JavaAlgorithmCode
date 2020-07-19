package com.lintcode.Parallel;

import java.util.Vector;

public class Consumer implements Runnable{

    private final Vector sharedQueue;
    private final int size;

    public Consumer(Vector sharedQueue, int size){
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+consume());
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int consume(){
        while(sharedQueue.isEmpty()){
            synchronized (sharedQueue){
                System.out.println("Queue is empty "+Thread.currentThread().getName()+" is waiting , size: " + sharedQueue.size());
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (sharedQueue){
            sharedQueue.notifyAll();
            return (Integer)sharedQueue.remove(0);
        }
    }
}
