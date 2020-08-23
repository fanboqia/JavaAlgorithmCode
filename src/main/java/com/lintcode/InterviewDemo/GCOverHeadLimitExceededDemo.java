package com.lintcode.InterviewDemo;

import java.util.ArrayList;
import java.util.List;

public class GCOverHeadLimitExceededDemo {
    //-Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
    public static void main(String[] args) throws Exception{
        int i = 0;
        List<String> list = new ArrayList<>();
        try{
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
