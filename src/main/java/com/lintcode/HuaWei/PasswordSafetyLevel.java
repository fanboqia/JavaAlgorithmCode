package com.lintcode.HuaWei;

import java.util.Scanner;

public class PasswordSafetyLevel {

    public enum Safelevel{
        VERY_SECURE,

        SECURE,

        VERY_STRONG,

        STRONG,

        AVERAGE,

        WEAK,

        VERY_WEAK,
    }

    public static boolean isChar(char chr){
        return (!Character.isLetter(chr) && !Character.isDigit(chr)
                && !Character.isWhitespace(chr));
    }

    public static int getLengthMark(String pPasswordStr){
        int pLen = pPasswordStr.length();
        if(pLen <= 4){
            return 5;
        }else if(pLen >=5 && pLen <= 7){
            return 10;
        }else{
            return 25;
        }
    }

    public static int getAlphaMark(String pPasswordStr){
        char[] chrs = pPasswordStr.toCharArray();
        boolean hasLower = false;
        boolean hasUpper = false;
        int count = 0;
        int lowerCount = 0;
        int higherCount = 0;
        for(int i = 0; i < chrs.length; i++){
            if(Character.isLetter(chrs[i])){
                count++;
            }
            if(Character.isLowerCase(chrs[i])){
                hasLower = true;
                lowerCount++;
            }
            if(Character.isUpperCase(chrs[i])){
                hasUpper = true;
                higherCount++;
            }
        }
        if(count == 0){
            return 0;
        }
        if(lowerCount == count || higherCount == count){
            return 10;
        }
        if(hasLower && hasUpper){
            return 20;
        }
        return 0;
    }

    public static int getDigitMark(String pPasswordStr){
        char[] chrs = pPasswordStr.toCharArray();
        int count = 0;
        for(int i = 0; i < chrs.length; i++){
            if(Character.isDigit(chrs[i])){
                count++;
            }
        }
        if(count == 0){
            return 0;
        }
        if(count == 1){
            return 10;
        }
        if(count > 1){
            return 20;
        }
        return 0;
    }

    public static int getCharMark(String pPasswordStr){
        char[] chrs = pPasswordStr.toCharArray();
        int count = 0;
        for(int i = 0; i < chrs.length; i++){
            if(isChar(chrs[i])){
                count++;
            }
        }
        if(count == 0){
            return 0;
        }
        if(count == 1){
            return 10;
        }
        if(count > 1){
            return 25;
        }
        return 0;
    }

    public static int getRewardMark(String pPasswordStr){
        char[] chrs = pPasswordStr.toCharArray();
        boolean hasDigit = false;
        boolean hasAlpha = false;
        boolean hasChar = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        for(int i = 0; i < chrs.length; i++){
            if(Character.isDigit(chrs[i])){
                hasDigit = true;
            }
            if(Character.isLetter(chrs[i])){
                hasAlpha = true;
            }
            if(Character.isLowerCase(chrs[i])){
                hasLower = true;
            }
            if(Character.isUpperCase(chrs[i])){
                hasUpper = true;
            }
            if(Character.isUpperCase(chrs[i])){
                hasUpper = true;
            }
            if(isChar(chrs[i])){
                hasChar = true;
            }
        }
        if(hasAlpha && hasDigit){
            if(hasChar){
                if(hasUpper && hasLower){
                    return 5;
                }
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public static Safelevel GetPwdSecurityLevel(String pPasswordStr)
    {
        int sum = 0;
        sum+=getLengthMark(pPasswordStr);
        sum+=getAlphaMark(pPasswordStr);
        sum+=getDigitMark(pPasswordStr);
        sum+=getCharMark(pPasswordStr);
        sum+=getRewardMark(pPasswordStr);
        if(sum >= 90){
            return Safelevel.VERY_SECURE;
        }
        if(sum >= 80){
            return Safelevel.SECURE;
        }
        if(sum >= 70){
            return Safelevel.VERY_STRONG;
        }
        if(sum >= 60){
            return Safelevel.STRONG;
        }
        if(sum >= 50){
            return Safelevel.AVERAGE;
        }
        if(sum >= 25){
            return Safelevel.WEAK;
        }
        return Safelevel.VERY_WEAK;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String password = sc.nextLine();
            System.out.println(GetPwdSecurityLevel(password));
        }
        sc.close();
    }
}
