package com.lintcode.InterviewDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//阻塞队列版本生产者与消费者问题
class SharedData{
    private volatile boolean flag = true;
    private AtomicInteger count = new AtomicInteger();
    private BlockingQueue<Integer> queue;

    public SharedData(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void prod() throws Exception{
        Integer i = null;
        while(flag){
            i = count.getAndIncrement();
            boolean res = queue.offer(i,2L, TimeUnit.SECONDS);
            if(res){
                System.out.println(Thread.currentThread().getName()+" 插入 "+i+" 成功！");
            }else{
                System.out.println(Thread.currentThread().getName()+"等待超过2秒, 插入 "+i+" 失败！");
            }
            //生产不能太快
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void cons() throws Exception{
        Integer res = null;
        while(flag){
            res = queue.poll(2L, TimeUnit.SECONDS);
            if(res != null){
                System.out.println(Thread.currentThread().getName()+" 获取 "+res+" 成功！");
            }else{
                flag = false;
                System.out.println(Thread.currentThread().getName()+"等待超过2秒, 获取 "+res+" 失败！");
            }
        }
    }

    public void stop(){
        flag = false;
    }
}

public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue<Integer>();
        SharedData data = new SharedData(queue);
        new Thread(()->{
            try {
                data.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"producer").start();

        new Thread(()->{
            try {
                data.cons();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();

        //让生产者消费者运行5秒
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //叫停
        data.stop();
    }
}
