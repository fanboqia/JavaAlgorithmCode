package com.lintcode;

public class Sqrt {

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public static int sqrt(int x) {
        // write your code here
        long mid = x;
        while(mid*mid > x){
            mid = mid / 2;
        }
        if(mid * mid == x){
            return (int)mid;
        }
        while(mid * mid < x){
            mid += 1;
        }
        return (int)mid-1;
    }
}
