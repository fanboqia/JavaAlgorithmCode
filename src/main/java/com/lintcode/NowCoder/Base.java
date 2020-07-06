package com.lintcode.NowCoder;

//1.首先，需要明白类的加载顺序。
//(1) 父类静态代码块(包括静态初始化块，静态属性，但不包括静态方法)
//(2) 子类静态代码块(包括静态初始化块，静态属性，但不包括静态方法 )
//(3) 父类非静态代码块( 包括非静态初始化块，非静态属性 )
//(4) 父类构造函数
//(5) 子类非静态代码块 ( 包括非静态初始化块，非静态属性 )
//(6) 子类构造函数
//其中：类中静态块按照声明顺序执行，并且(1)和(2)不需要调用new类实例的时候就执行了(意思就是在类加载到方法区的时候执行的)
//2.其次，需要理解子类覆盖父类方法的问题，也就是方法重写实现多态问题。
//Base b = new Sub();它为多态的一种表现形式，声明是Base,实现是Sub类， 理解为 b 编译时表现为Base类特性，运行时表现为Sub类特性。
//当子类覆盖了父类的方法后，意思是父类的方法已经被重写，题中 父类初始化调用的方法为子类实现的方法，子类实现的方法中调用的baseName为子类中的私有属性。
//由1.可知，此时只执行到步骤4.,子类非静态代码块和初始化步骤还没有到，子类中的baseName还没有被初始化。所以此时 baseName为空。 所以为null。
public class Base
{
    private String baseName = "base";
    //1
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        //2
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}