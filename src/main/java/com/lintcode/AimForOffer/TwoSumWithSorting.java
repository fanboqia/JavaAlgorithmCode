package com.lintcode.AimForOffer;

import java.util.ArrayList;

public class TwoSumWithSorting {
    //链接：https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b
    //来源：牛客网
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }

        }
        return list;
    }
}
