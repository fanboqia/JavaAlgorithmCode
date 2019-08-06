package com.lintcode;

public class MaximumSwap {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public static int maximumSwap(int num) {
        //convert num into string
        String digits = num + "";
        int digitSize = digits.length();
        if(digitSize < 2){
            return num;
        }
        int[] digitsArr = new int[digitSize];
        int i = 0;
        while(i < digitSize){
            digitsArr[i] = digits.charAt(i)-'0';
            i++;
        }
        //find the largest digit except the first digit
        int max = 0;
        int maxIndex = 0;
        for(int k = 1; k < i;k++){
            //same digit then priority considered to the last digits
            if(digitsArr[k] >= max){
                max = digitsArr[k];
                maxIndex = k;
            }
        }
        //find digit to swap
        int j = 0;
        //only swap with index before maxIndex and still look for remaining digits to swap
        while(j < maxIndex && digitsArr[j] >= max){
            j++;
        }
        //swap the two digits
        int tmp =  digitsArr[j];
        digitsArr[j] =  digitsArr[maxIndex];
        digitsArr[maxIndex] =  tmp;
        //build new number
        int newNum = 0;
        for(int z = 0; z < i; z++){
            newNum = newNum*10 + digitsArr[z];
        }
        return newNum;
    }
}
