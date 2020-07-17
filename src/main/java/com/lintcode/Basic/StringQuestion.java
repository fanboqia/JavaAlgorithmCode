package com.lintcode.Basic;

public class StringQuestion {
    public static void main(String[] args){
        String a = "ab";//是在常量池中获取对象("ab" 属于字符串字面量，因此编译时期会在常量池中创建一个字符串对象，如果常量池中已经存在该字符串对象则直接引用)
        String b = "ab";
        String c = new String("ab"); //一共会创建两个字符串对象一个在堆中，一个在常量池中（前提是常量池中还没有 "ab" 象）
        String d = c.intern(); //String.intern() 是一个 Native 方法，它的作用是： 如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，
                               // 则返回常量池中该字符串的引用； 如果没有，则在常量池中创建与此 String 内容相同的字符串，并返回常量池中创建的字符串的引用
        System.out.println(a==b); // true
        System.out.println(a==c); // false
        System.out.println(d == b);// true

        //字符串拼接：
        String a1 = "a";
        String b1 = "b";

        String str1 = "a" + "b";//常量池中的对象
        String str2 = a1 + b1; //在堆上创建的新的对象
        String str3 = "ab";//常量池中的对象
        System.out.println(str1 == str2);//false
        System.out.println(str1 == str3);//true
        System.out.println(str2 == str3);//false
    }
}
