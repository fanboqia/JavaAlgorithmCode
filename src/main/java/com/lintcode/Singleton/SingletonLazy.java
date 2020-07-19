package com.lintcode.Singleton;

public class SingletonLazy {
    private static SingletonLazy s = null;
    private SingletonLazy(){}
    public static synchronized SingletonLazy getInstance(){
        if(s == null){
            return new SingletonLazy();
        }
        return s;
    }
}
