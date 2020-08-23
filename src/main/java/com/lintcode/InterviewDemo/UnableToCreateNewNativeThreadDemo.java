package com.lintcode.InterviewDemo;

//创建过多线程
public class UnableToCreateNewNativeThreadDemo {
    public static void main(String[] args) {
        int i = 0;
        while(true){
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },i+"").start();
            i++;
        }
    }
}
