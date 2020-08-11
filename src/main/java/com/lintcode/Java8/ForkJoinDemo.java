package com.lintcode.Java8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Integer> {

    private int begin;
    private int end;
    private int result = 0;

    public ForkJoinDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-begin <= 10) {
            for (int i = this.begin; i < this.end; i++) {
                result += i;
            }
        }else{
            int mid = (begin + end)/2;
            ForkJoinDemo t1 = new ForkJoinDemo(begin,mid);
            ForkJoinDemo t2 = new ForkJoinDemo(mid+1,end);
            t1.fork();
            t2.fork();
            result = t1.join()+t2.join();
        }
        return result;
    }

    public static void main(String[] args) {
        ForkJoinDemo demo = new ForkJoinDemo(0,100);
        ForkJoinPool task = new ForkJoinPool();
        ForkJoinTask<Integer> res = task.submit(demo);
        try {
            System.out.println(res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        task.shutdown();
    }

}
