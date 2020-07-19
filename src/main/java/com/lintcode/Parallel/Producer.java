package com.lintcode.Parallel;

import java.util.Vector;

public class Producer implements Runnable{

    private final Vector sharedQueue;
    private final int size;

    @Override
    public void run() {
        for(int i = 0; i < 7; i++){
            System.out.println("Produced: "+ i);
            produce(i);
        }
    }

    public void produce(int i){
        while(sharedQueue.size() == this.size){
            synchronized (sharedQueue){
                System.out.println("Queue is full "+Thread.currentThread().getName()+" is waiting , size: " + sharedQueue.size());
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (sharedQueue){
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }

    public Producer(Vector sharedQueue, int size){
        this.sharedQueue = sharedQueue;
        this.size = size;
    }
}
