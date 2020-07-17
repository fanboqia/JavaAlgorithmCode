package com.lintcode.Basic;

public class NumAppearTimesInSortArr {
    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){return 0;}
        int start = 0;
        int end = array.length - 1;
        int mid;
        int index = -1;
        while(start <= end){
            mid = start + ((end - start) >> 1);
            if(array[mid] == k){
                index = mid;
                break;
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        if(index == -1){
            return 0;
        }
        int centerLeft = index;
        int centerRight = index;
        int count = 1;
        while(centerLeft-1 >= 0 && array[centerLeft-1] == k){
            centerLeft--;
            count++;
        }
        while(centerRight+1 < array.length && array[centerRight+1] == k){
            centerRight++;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(GetNumberOfK(new int[]{1,1,2,2,3,4,4,4,7},100));
    }
}
