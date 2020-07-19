package com.lintcode.Singleton;

public class SingletonDCL {
    //1.分配内存
    //2.初始化
    //3.指向
    //2,3发生指令重排
    private volatile static SingletonDCL s = null;
    private SingletonDCL(){}
    public static SingletonDCL getInstance(){
        if(s == null){
            synchronized (SingletonDCL.class){
                if(s == null){
                    return new SingletonDCL();
                }
            }
        }
        return s;
    }
}
