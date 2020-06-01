package com.lintcode.polymorphism;

public class SubTest extends AbstractTest{
    @Override
    public void abstractFunc() {
        System.out.println("from SubTest");
    }

    //当有子类重写了抽象类的普通方法，抽象类的调用自动会指向子类的全部实现！
//    @Override
//    public void normalFunc() {
//        System.out.println("normal Func from SubTest");
//    }

    public static void main(String[] args){
        AbstractTest test = new SubTest();
        test.normalFunc();
        test.abstractFunc();
        SubTest test1 = new SubTest();
        test1.normalFunc();
        test.abstractFunc();

        //匿名内部类
        AbstractTest test2 = new AbstractTest(){

            @Override
            public void abstractFunc() {
                System.out.println("hhh");
            }
        };

        test2.abstractFunc();

    }
}
