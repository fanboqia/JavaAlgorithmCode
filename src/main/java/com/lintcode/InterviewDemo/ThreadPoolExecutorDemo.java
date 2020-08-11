package com.lintcode.InterviewDemo;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void testAPI(){
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一个池处理线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一个池处理线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一个池处理线程
        try {
            for(int i = 0; i < 10; i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public static void understandAbortProcess(){
        ExecutorService pool = new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //9个的话就是产生拒接策略
        for(int i = 1; i <= 9; i++){
            final int temp = i;
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+" 处理 "+temp+" 顾客!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }

    //CallerRunsPolicy就是从哪来的回哪去,尽量帮你处理
    public static void understandCallerRunsPolicyProcess(){
        ExecutorService pool = new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        //9个的话就是产生拒接策略
        for(int i = 1; i <= 10; i++){
            final int temp = i;
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+" 处理 "+temp+" 顾客!");
            });
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        understandCallerRunsPolicyProcess();
    }
}
