package com.lintcode.Java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception{
        //没有返回值得异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" 没有返回值, update sql ok!");
        });
        completableFuture.get();
        //有返回值的
        CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"有返回值, insert sql ok!");
            int age = 10/0;
            return 1024;
        }).whenComplete((t,u)->{
            System.out.println(t);
            System.out.println(u);
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return 4444;
        });
        System.out.println(completableFuture1.get());
    }
}
