package com.lintcode;

public class HistogramMaxArea {

    //枚举法:从当前的柱，往前算，比较面积大小（短板效应），面积是高度最低的才能行
    public static Integer find(int[] arr){
        if(arr==null||arr.length==0){return 0;}
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            int minHeight = arr[i];
            int maxLocal = arr[i];
            int m = 1;
            for(int j = i; j >= 0; j--){
                if(minHeight > arr[j]){
                    minHeight = arr[j];
                }
                if(maxLocal < minHeight * m){
                    maxLocal = minHeight * m;
                }
                m++;
            }
            if(maxLocal > max){
                max = maxLocal;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{2,1,5,6,2,3}));
    }
}
