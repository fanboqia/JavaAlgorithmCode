package com.lintcode.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface TestInterface{
    public void test();
    public String test2();
    //public String toString();
}

//动态代理打印proxy会栈溢出
public class InvocationPrint implements InvocationHandler {

    public Object object;

    public InvocationPrint(Object obj){
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy.toString();
        //proxy.equals("");
        //proxy.hashCode();
        System.out.println("before");
        Object res = method.invoke(object,args);
        System.out.println("after");
        return res;
    }

    public static void main(String[] args) {
        TestInterface t = new Test();
        InvocationPrint handler = new InvocationPrint(t);
        TestInterface res = (TestInterface)Proxy.newProxyInstance(t.getClass().getClassLoader(),new Class[]{TestInterface.class},handler);
        System.out.println(res.toString());
    }
}

class Test implements TestInterface{
    public void test(){
        System.out.println("test");
    }

    public String test2(){
        return "test2";
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return "4444";
    }
}


