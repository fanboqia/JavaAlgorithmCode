package com.lintcode.Basic;

//static静态块优先加载
//取决于main的入口，如果在子类，那么父类的静态块优先被加载，然后加载子类
//new 对象的时候，先调用父类的构造器，再调用子类的构造器
class Load2 extends LoadingSequence{
    static{
        System.out.println("3");
    }
    public Load2(){
        System.out.println("4");
    }

    public static void main(String[] args) {
        LoadingSequence a = new Load2();
        a = new LoadingSequence();
    }
}

public class LoadingSequence {
    static{
        System.out.println("1");
    }
    public LoadingSequence() {
        System.out.println("2");
    }
}


