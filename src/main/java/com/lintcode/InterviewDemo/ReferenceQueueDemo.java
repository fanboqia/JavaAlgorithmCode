package com.lintcode.InterviewDemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

//回收的时候，弱引用最后被放入引用队列中
public class ReferenceQueueDemo {
    public static void main(String[] args) throws Exception{
        Object o1 = new Object();
        ReferenceQueue queue = new ReferenceQueue<>();
        WeakReference o2 = new WeakReference<>(o1,queue);
        //PhantomReference o2 = new PhantomReference<>(o1,queue);

        o1 =  null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o2.get());
        System.out.println(queue.poll());
    }
}
