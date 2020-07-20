package com.lintcode.dataStructure;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

//位图数据结构，方便海量数据排序，大量统计
//https://blog.csdn.net/u012736409/article/details/53735429
//https://www.jianshu.com/p/4fbad3a6d253
public class BitSetDemo {

    public static void sortArray() {
        int[] array = new int[] { 423, 700, 9999, 2323, 356, 6400, 1,2,3,2,2,2,2 };
        BitSet bitSet = new BitSet(2 << 13);
        // 虽然可以自动扩容，但尽量在构造时指定估算大小,默认为64
        System.out.println("BitSet size: " + bitSet.size());

        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i]);
        }
        //剔除重复数字后的元素个数
        int bitLen=bitSet.cardinality();

        //进行排序，即把bit为true的元素复制到另一个数组
        int[] orderedArray = new int[bitLen];
        int k = 0;
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            orderedArray[k++] = i;
        }

        System.out.println("After ordering: ");
        for (int i = 0; i < bitLen; i++) {
            System.out.print(orderedArray[i] + "\t");
        }

        System.out.println("iterate over the true bits in a BitSet");
        //或直接迭代BitSet中bit为true的元素iterate over the true bits in a BitSet
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            System.out.print(i+"\t");
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args){
        sortArray();
    }

    //有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
    public static void alibaba(){
        Random random=new Random();

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10000000;i++)
        {
            int randomResult=random.nextInt(100000000);
            list.add(randomResult);
        }
        System.out.println("产生的随机数有");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        BitSet bitSet=new BitSet(100000000);
        for(int i=0;i<10000000;i++)
        {
            bitSet.set(list.get(i));
        }

        System.out.println("0~1亿不在上述随机数中有"+bitSet.cardinality());
        for (int i = 0; i < 100000000; i++)
        {
            if(!bitSet.get(i))
            {
                System.out.println(i);
            }
        }
    }
}
