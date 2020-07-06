package com.lintcode.HuaWei;

import java.util.Scanner;

public class BigIntegerAdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();

            // 求出两个字符串中较长的那个字符串长度
            int lenA = a.length();
            int lenB = b.length();
            int lenS = Math.max(lenA, lenB);

            // arrS保存最终生成的结果
            int[] arrA = new int[lenS];
            int[] arrB = new int[lenS];
            int[] arrS = new int[lenS + 1];

            for (int i = 0; i < lenA; i++) {
                arrA[i] = a.charAt(lenA - 1 - i) - '0';
            }

            for (int i = 0; i < lenB; i++) {
                arrB[i] = b.charAt(lenB - 1 - i) - '0';
            }

            for (int i = 0; i < lenS; i++) {
                int sum = arrS[i] + arrA[i] + arrB[i];
                int flag = sum /10;
                arrS[i]  = sum % 10;
                arrS[i+1] += flag;
            }

            for (int i = arrS[lenS] == 0?1:0; i < lenS + 1; i++) {
                System.out.print(arrS[lenS - i]);
            }

            System.out.println();

        }

        scan.close();
    }

}

//我的加法实现，考虑正负数
class MyAdd{
    public static String add(String s1,String s2){
        boolean isNeg = false;
        if(s1.charAt(0) == '-' && s2.charAt(0) == '-'){
            s1 = s1.substring(1);
            s2 = s2.substring(1);
            isNeg = true;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int maxLen = len1 > len2 ? len1: len2;
        if(len1 < len2){
            for(int i = 0; i < len2-len1; i++){
                s1 = "0"+s1;
            }
        }else{
            for(int i = 0; i < len1-len2; i++){
                s2 = "0"+s2;
            }
        }
        char[] sa1 = s1.toCharArray();
        char[] sa2 = s2.toCharArray();
        char[] res = new char[maxLen+1];
        for(int i = 0;i <= maxLen; i++){
            res[i] = '0';
        }

        for(int i = maxLen; i >= 1; i--){
            int n1 = (sa1[i-1]-'0');
            int n2 = (sa2[i-1]-'0');
            int sum = n1 + n2;
            if(sum / 10 > 0){
                res[i] = (char)(sum % 10 + res[i]);
                res[i-1] = (char)(res[i-1]+1);
            }else{
                res[i] = (char)(sum + res[i]);
            }
        }
        String resStr = String.valueOf(res);
        resStr = resStr.charAt(0) == '0' ? resStr.substring(1) : resStr;
        if(isNeg){
            resStr = "-"+resStr;
        }
        return resStr;
    }

    public static String cal(String s1, String s2){
        if(s1 == null || s2 == null){return null;}
        if(s1.length() == 0){return s2;}
        if(s2.length() == 0){return s1;}
        if(s1.charAt(0) == '-' && s2.charAt(0) == '-') {
            return add(s1, s2);
        }else if(s1.charAt(0) == '-' && s2.charAt(0) != '-'){
            return sub(s1,s2);
        }else if(s1.charAt(0) != '-' && s2.charAt(0) == '-'){
            return sub(s1,s2);
        }else{
            return add(s1,s2);
        }
    }

    public static String sub(String s1, String s2){
        String str1 = s1;
        String str2 = s2;
        boolean isStr1Neg = false;
        if(s1.charAt(0) == '-'){
            str1 = s1.substring(1);
            isStr1Neg = true;
        }
        if(s2.charAt(0) == '-'){
            str2 = s2.substring(1);
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        if(len1 < len2){
            for(int i = 0; i < len2-len1; i++){
                str1 = "0"+str1;
            }
        }else{
            for(int i = 0; i < len1-len2; i++){
                str2 = "0"+str2;
            }
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        if(str1.compareTo(str2) < 0){
            for(int i = maxLen - 1; i >= 0; i--){
                int n2 = ch2[i] - '0';
                int n1 = ch1[i] - '0';
                if(n2 - n1 >= 0){
                    ch2[i] = (char)(n2 - n1 + '0');
                }else{
                    ch2[i]=(char)(n2+10-n1+'0');
                    //向前借位
                    int j = 0;
                    while(i-j >= 1 && ch2[i-1-j] == '0'){
                        ch2[i-1-j] = '9';
                        j++;
                    }
                    ch2[i-1-j]--;
                }
            }
            StringBuilder sb = new StringBuilder();
            //负数
            if(!isStr1Neg){
                sb.append("-");
            }
            int j = 0;
            while(j < ch2.length && ch2[j] == '0'){
                j++;
            }
            //等于0的情况
            if(j == ch2.length){
                return "0";
            }
            for(int i = j; i < ch2.length; i++){
                sb.append(ch2[i]);
            }
            return sb.toString();
        }else{
            for(int i = maxLen - 1; i >= 0; i--){
                int n2 = ch2[i] - '0';
                int n1 = ch1[i] - '0';
                if(n1 - n2 >= 0){
                    ch1[i] = (char)(n1 - n2 + '0');
                }else{
                    ch1[i]=(char)(n1+10-n2+'0');
                    //向前借位
                    int j = 0;
                    while(i-j >= 1 && ch1[i-1-j] == '0'){
                        ch1[i-1-j] = '9';
                        j++;
                    }
                    ch1[i-1-j]--;
                }
            }
            StringBuilder sb = new StringBuilder();
            //负数
            if(isStr1Neg){
                sb.append("-");
            }
            int j = 0;
            while(j < ch1.length && ch1[j] == '0'){
                j++;
            }
            //等于0的情况
            if(j == ch1.length){
                return "0";
            }
            for(int i = j; i < ch1.length; i++){
                sb.append(ch1[i]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(cal(s1,s2));
        }
        sc.close();
    }
}
