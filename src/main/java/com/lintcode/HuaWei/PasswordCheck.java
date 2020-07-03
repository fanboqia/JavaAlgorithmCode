package com.lintcode.HuaWei;

public class PasswordCheck {

    public static boolean checkCharRepeat(String password){
        for(int i=0 ;i<password.length()-2 ;i++){
            String substr1 =password.substring(i, i+3);
            if (password.substring(i+1).contains(substr1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(checkCharRepeat("ababa"));
    }
}
