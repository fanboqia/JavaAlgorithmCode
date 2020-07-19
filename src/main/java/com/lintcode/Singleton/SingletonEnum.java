package com.lintcode.Singleton;

//枚举实现单例模式，可以防止反射和反序列化攻击
//最佳实践
public enum SingletonEnum {
    INSTANCE;
    public SingletonEnum getInstance(){
        return INSTANCE;
    }
}
