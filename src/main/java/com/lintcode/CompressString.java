package com.lintcode;

import java.util.HashMap;
import java.util.Map;

public class CompressString {

    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public static String compress(String originalString) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < originalString.length();){
            int j = 0;
            for(;i+j < originalString.length() && originalString.charAt(i+j) == originalString.charAt(i); j++){
            }
            sb.append((originalString.charAt(i)+"")+j);
            i = i+j;
        }
        String newStr = sb.toString();
        if(newStr.length() >= originalString.length()){
            return originalString;
        }else{
            return newStr;
        }
    }
}
