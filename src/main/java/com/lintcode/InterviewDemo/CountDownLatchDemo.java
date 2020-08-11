package com.lintcode.InterviewDemo;

import java.util.concurrent.CountDownLatch;

enum items{
    ONE(1,"a"),TWO(2,"b"),THREE(3,"c");
    private Integer code;
    private String name;

    items(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static items get(int index){
        items[] its = items.values();
        for(items item : its){
            if(item.code == index){
                return item;
            }
        }
        return null;
    }
}

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for(int i = 1; i <= 3; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" enter!");
                //这句话必须放最后
                latch.countDown();
            },items.get(i).getName()).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over!");
    }
}
