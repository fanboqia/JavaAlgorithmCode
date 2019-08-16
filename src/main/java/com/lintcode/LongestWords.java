package com.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWords {

    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public static List<String> longestWords(String[] dictionary) {
        // write your code here
        if(dictionary == null || dictionary.length == 0){
            return null;
        }
        Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        int maxLen = 0;
        for(String dic : dictionary){
            int dicLen = dic.length();
            if(maxLen < dicLen){
                maxLen = dicLen;
            }
            if(map.containsKey(dicLen)){
                map.get(dicLen).add(dic);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(dic);
                map.put(dicLen,list);
            }
        }
        return map.get(maxLen);
    }
}
