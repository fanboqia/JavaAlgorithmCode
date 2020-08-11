package com.lintcode.InterviewDemo;

class B{
    volatile int num = 0;
    public void add(){
        this.num++;
    }
}

//Volatile不保证原子性demo
public class VolatileAtomicity {
    public static void main(String[] args) {
        B b = new B();
        for(int i = 0; i < 20; i++){
            new Thread(()->{
                for(int j = 1; j <= 1000; j++){
                    b.add();
                }
            },String.valueOf(i)).start();
        }

        //一个GC线程，一个main线程
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println("final value: "+b.num);
    }
}
