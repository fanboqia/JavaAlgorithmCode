package com.lintcode.NowCoder;

public class Byte {
    public void add(byte b)
    {
        b = b++;
    }
    public void test()
    {
        //byte上溢出
        byte a = 127;
        byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
    public static void main(String[] args){
        new Byte().test();
    }
}
