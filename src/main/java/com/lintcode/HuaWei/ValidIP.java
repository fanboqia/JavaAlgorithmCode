package com.lintcode.HuaWei;

import java.util.regex.Pattern;

public class ValidIP {

    public static boolean isIP(String str){
        String[] nums  = str.split("\\.");
        if(nums.length != 4){
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            if(!Pattern.matches("^[0-9]*$", nums[i])){
                return false;
            }
            int num = Integer.parseInt(nums[i]);
            if(num < 0 || num > 255){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isIP("-1.1.2.3.0"));
    }
}
