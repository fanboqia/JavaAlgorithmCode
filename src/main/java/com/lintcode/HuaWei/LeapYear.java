package com.lintcode.HuaWei;

import java.util.Scanner;

public class LeapYear {
    public static int[] md = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int[] mdPrefix = new int[13];

    static{
        mdPrefix[1] = 0;
        mdPrefix[2] = 31;
        for(int i = 3; i <= 12; i++){
            mdPrefix[i] = mdPrefix[i-1]+md[i-1];
        }
    }

    public static boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0)||year % 400 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static int iConverDateToDay(int year, int month, int day)
    {
        int passDays = mdPrefix[month];
        /* 在这里实现功能，将结果填入输入数组中*/
        if(isLeapYear(year) && month > 2){
            return passDays + day + 1;
        }
        return passDays + day;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int days = iConverDateToDay(year,month,day);
            System.out.println(days);
        }
    }
}
