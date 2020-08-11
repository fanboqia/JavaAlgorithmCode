package com.lintcode.InterviewDemo;

import java.util.concurrent.TimeUnit;

//volatile保证可见性demo
class A{
    volatile int num = 0;
    public void change(){
        this.num = 60;
    }
}
public class VolatileDemo {
    public static void main(String[] args) {

        A a = new A();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            a.change();
            System.out.println(Thread.currentThread().getName()+"\t change to 60");
        },"AAA").start();

        while(a.num == 0){

        }

        System.out.println("over!");
    }
}
