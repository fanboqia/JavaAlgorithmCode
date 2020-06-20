package com.lintcode.AimForOffer;

//题目描述
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
//但不知道有几个数字是重复的。也不知道每个数字重复几次。
//请找出数组中任意一个重复的数字。
//例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
public class DuplicateNumbers {

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0){duplication[0] = -1; return false;}
        int[] countArray = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            countArray[numbers[i]]++;
        }
        for(int i = 0; i < countArray.length; i++){
            if(countArray[i] > 1){
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    //以数组下表对应里头的内容，不同的就归位！
    public static boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (length <= 0 || numbers == null) {
            return false;
        }

        int index = 0;
        while (index < length) {
            if (numbers[index] == index) { // 当前下标index的值刚好为index
                index++;
            } else {
                int tmp = numbers[index];
                if (tmp == numbers[tmp]) { // 要交换位置的两个数相同
                    duplication[0] = tmp;
                    return true;
                } else { // 交换位置
                    numbers[index] = numbers[tmp];
                    numbers[tmp] = tmp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] duplication = new int[1];
        duplicate2(new int[]{2,2,5,0,2,5,3},5, duplication);
    }
}
