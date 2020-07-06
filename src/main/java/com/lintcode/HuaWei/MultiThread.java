package com.lintcode.HuaWei;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//ABCDABCD打印
//自己加锁flag实现
public class MultiThread{

    public static ArrayList<String> list = new ArrayList<String>();
    public static volatile int token = 1;
    public static volatile boolean exit = false;
    public static int times = 0;
    public static int count = 0;
    public static AtomicInteger counter = new AtomicInteger();

    public synchronized static void put(String val){
        list.add(val);
        count++;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            count = 0;
            counter.set(0);
            times = num*4;
            ThreadA t1 = new ThreadA();
            t1.start();
            ThreadB t2 = new ThreadB();
            t2.start();
            ThreadC t3 = new ThreadC();
            t3.start();
            ThreadD t4 = new ThreadD();
            t4.start();
            try{
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            }catch(Exception e){

            }finally{
                for(String str : list){
                    System.out.print(str);
                }
            }
            t1.stop();
            t2.stop();
            t3.stop();
            t4.stop();
            exit = false;
            token = 1;
            list.clear();
            System.out.println();
        }
        sc.close();
    }
}

class ThreadA extends Thread{
    public void run(){
        while(!MultiThread.exit){
            if(MultiThread.counter.get() == MultiThread.times){
                MultiThread.exit = true;
                break;
            }
            if(MultiThread.token == 1){
                MultiThread.put("A");
                MultiThread.counter.getAndIncrement();
                MultiThread.token = 2;
            }
        }
    }
}

class ThreadB extends Thread{
    public void run(){
        while(!MultiThread.exit){
            if(MultiThread.counter.get() == MultiThread.times){
                MultiThread.exit = true;
                break;
            }
            if(MultiThread.token == 2){
                MultiThread.put("B");
                MultiThread.counter.getAndIncrement();
                MultiThread.token = 3;
            }
        }
    }
}

class ThreadC extends Thread{
    public void run(){
        while(!MultiThread.exit){
            if(MultiThread.counter.get() == MultiThread.times){
                MultiThread.exit = true;
                break;
            }
            if(MultiThread.token == 3){
                MultiThread.put("C");
                MultiThread.counter.getAndIncrement();
                MultiThread.token = 4;
            }
        }
    }
}

class ThreadD extends Thread{
    public void run(){
        while(!MultiThread.exit){
            if(MultiThread.counter.get() == MultiThread.times){
                MultiThread.exit = true;
                break;
            }
            if(MultiThread.token == 4){
                MultiThread.put("D");
                MultiThread.counter.getAndIncrement();
                MultiThread.token = 1;
            }
        }
    }
}

//线程池
class Myrunnable implements Runnable{
    public String output;
    public Myrunnable(String output){
        this.output = output;
    }
    public void run(){
        System.out.print(output);
    }
}
class ThreadPool {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        while(in.hasNextInt()) {
            int n=in.nextInt();
            for (int i = 0; i < n; i++) {
                threadPool.execute(new Myrunnable("A"));
                threadPool.execute(new Myrunnable("B"));
                threadPool.execute(new Myrunnable("C"));
                threadPool.execute(new Myrunnable("D"));
            }
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println();
        }
        threadPool.shutdown();
    }
}

//大佬解法
//借助于线程可见性变量,以及线程基本应用,完美AC
class ShowOff{
    public static volatile int count=0;//线程可见性变量
    public static char []buff=new char[1024*4];
    public static int index=0;
    public static  int times=10;//执行次数
    public static class CountThread extends Thread{
        public int mycount=0;
        public char ch=' ';
        public CountThread(int mycount,char ch){
            this.mycount=mycount;
            this.ch=ch;
        }
        @Override
        public void run() {
            for(int i=0;i<=times;i++){
                while(mycount!=count){
                    //自旋等待执行,不需要阻塞
                }
                buff[index]=ch;//放入缓存区
                index++;
                count=(count+1)%4;//切换到下一个线程执行
            }
        }
    }
    public static void main(String[] arg) throws Exception{
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            index=0;//设置缓冲区索引
            count=0;
            times=s.nextInt();
            CountThread a1=new CountThread(0,'A');
            CountThread a2=new CountThread(1,'B');
            CountThread a3=new CountThread(2,'C');
            CountThread a4=new CountThread(3,'D');
            a1.start();
            a2.start();
            a3.start();
            a4.start();
            a1.join();
            a2.join();
            a3.join();
            a4.join();
            for(int i=0;i<times*4;i++)
                System.out.print(buff[i]);
            System.out.println();
        }
    }
}

