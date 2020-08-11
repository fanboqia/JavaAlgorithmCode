package com.lintcode.InterviewDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable {

    public static void main(String[] args) throws Exception{
        FutureTask task = new FutureTask<>(new CallableDemo());
        Thread t1 = new Thread(task);
        t1.start();
        //get会阻塞,最好放到最后
        int res = (Integer)task.get();
        int i = 100;
        System.out.println(res+i);
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 1024;
    }
}
