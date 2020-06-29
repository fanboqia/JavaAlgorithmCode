package com.lintcode.Kujiale;

public class Demo4 {

    public static int findMaxAreaOfHistogram(int[] arr){
        if(arr == null || arr.length == 0){ return 0; }
        int maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            int minHeight = arr[i];
            int area = minHeight;
            for(int j = i+1; j < arr.length; j++){

                //获取当前宽度
                int width = (j + 1 - i);

                //更新最小的高度
                if(minHeight > arr[j]){
                    minHeight = arr[j];
                }

                //计算面积
                area = width * minHeight;

                //存储最大的面积
                if(maxArea < area){
                    maxArea = area;
                }

            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(findMaxAreaOfHistogram(arr));
        int[] arr1 = new int[]{1,2,3,4,5,6};
        System.out.println(findMaxAreaOfHistogram(arr1));
    }
}
