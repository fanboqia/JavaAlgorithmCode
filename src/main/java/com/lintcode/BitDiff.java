package com.lintcode;

import java.awt.font.OpenType;

public class BitDiff {

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        String aBin = Integer.toBinaryString(a);
        String bBin = Integer.toBinaryString(b);
        int maxLen = Math.max(aBin.length(),bBin.length());
        int diff = maxLen - Math.min(aBin.length(),bBin.length());
        StringBuilder sb = new StringBuilder();
        String preZeros = "";
        for(int i = 0; i < diff; i++){sb.append("0");}
        preZeros = sb.toString();
        if(aBin.length() > bBin.length()){
            bBin = preZeros + bBin;
        }else{
            aBin = preZeros + aBin;
        }
        int count = 0;
        for(int i = 0; i < maxLen; i++){
            if(aBin.charAt(i) != bBin.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
