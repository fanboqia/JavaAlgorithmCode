package com.lintcode.InterviewDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//-XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=20m
public class OOM_MetaspaceSizeDemo {
    static class OOMTest{}
    public static void main(String[] args) {
        try{
            int i = 0;
            while(true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                i++;
                enhancer.create();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
