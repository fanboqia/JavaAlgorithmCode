package com.lintcode.Singleton;

//静态内部类单例模式
//利用了classloader的机制来保证初始化instance时只有一个线程。
//只有显式通过调用getInstance()方法来回显式的装载singletonHolder类
public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass(){}

    private static class SingletonHolder{
        private static SingletonStaticInnerClass s = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance(){
        return SingletonHolder.s;
    }
}
