package com.lintcode.Singleton;

public class SingletonStarver {
    private static SingletonStarver s = new SingletonStarver();
    private SingletonStarver(){

    }
    public static SingletonStarver getInstance(){
        return s;
    }
}
