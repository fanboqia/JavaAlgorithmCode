package com.lintcode.AimForOffer;

//实现加法通过位运算符号
//https://www.jianshu.com/p/7bba031b11e7
public class AddWithBitOperation {

    public static int add(int a, int b){
        //通过异或获取不进位的每一位
        int sum = (a ^ b);
        //与运算，当都是1的时候，进位，向左一一位
        int carry = (a & b) << 1;
        //sum + carry就是最终结果 (sum ^ carry)
        while(carry != 0){
            int c = sum;
            int d = carry;
            sum = c ^ d;
            carry = (c & d) << 1;
        }
        return sum;
    }

    //减法运算11 - 6变形为加法运算11 + (-6)
    //一个数的负数就是正数的补码+1
    //+8就是00001000，而-8则是10001000
    public static int substract(int a, int b){
        return add(a,add(~b,1));
    }

    public static void main(String[] args){
       System.out.println(add(-12,4));
    }
}
