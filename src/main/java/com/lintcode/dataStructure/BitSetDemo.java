package com.lintcode.dataStructure;

import java.util.BitSet;

//位图数据结构，方便海量数据排序，大量统计
//https://blog.csdn.net/u012736409/article/details/53735429
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
}
