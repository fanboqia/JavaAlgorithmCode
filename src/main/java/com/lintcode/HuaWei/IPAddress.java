package com.lintcode.HuaWei;

import java.util.Scanner;

public class IPAddress {
    public static void convertToTenth(String str){
        String[] nums = str.split("\\.");
        if(nums.length != 4){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            String temp = Long.toBinaryString(Long.parseLong(nums[i]));
            StringBuilder sb1 = new StringBuilder();
            for(int j = 0; j < 8-temp.length(); j++){
                sb1.append("0");
            }
            sb.append(sb1.toString()+temp);
        }
        System.out.println(Long.valueOf(sb.toString(),2).toString());
    }

    private static long IptoTen(String ip) {
        String[] arr=ip.split("\\.");
        long n=Long.parseLong(arr[0]);

        for(int i=1;i<arr.length;i++){
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }

        return n;
    }

    public static void convertToIP(String str){
        String temp = Long.toBinaryString(Long.parseLong(str));
        StringBuilder sb1 = new StringBuilder();
        for(int j = 0; j < 32-temp.length(); j++){
            sb1.append("0");
        }
        String newStr = sb1.toString()+temp;
        String[] nums = new String[4];
        for(int i = 0; i < 4; i++){
            nums[i] = newStr.substring(i*8,(i+1)*8);
        }
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(String num : nums){
            if(!isFirst){
                sb.append("."+Long.valueOf(num,2).toString());
            }else{
                sb.append(Long.valueOf(num,2).toString());
                isFirst = false;
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String ip = sc.nextLine();
            String num = sc.nextLine();
            convertToTenth(ip);
            convertToIP(num);
        }
        sc.close();
    }
}
