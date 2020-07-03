package com.lintcode.HuaWei;

import java.util.*;

//频率统计
//对字符中的
//各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，
// 则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
//aadddccddc
//dca
public class FrequencyStat {

    //Map统计次数
    //字符串拼接->次数：字符
    //自定义排序
    //字符串.split(":")[1]
    public static String sort(String str){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);
            if(chr == ' ' || Character.isLetterOrDigit(chr)){
                if(map.containsKey(chr)){
                    map.put(chr,map.get(chr)+1);
                }else{
                    map.put(chr,1);
                }
            }
        }
        Set<String> set = new TreeSet<String>(new Comparator<String>(){
            public int compare(String s1, String s2){
                Integer s1Key = Integer.parseInt(s1.split(":")[0]);
                String s1Val = s1.split(":")[1];
                Integer s2Key = Integer.parseInt(s2.split(":")[0]);
                String s2Val = s2.split(":")[1];
                if(s2Key.compareTo(s1Key) == 0){
                    return s1Val.compareTo(s2Val);
                }
                return s2Key.compareTo(s1Key);
            }
        });
        for(Map.Entry entry : map.entrySet()){
            set.add(entry.getValue()+":"+entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for(String chr : set){
            sb.append(chr.split(":")[1]);
        }
        return sb.toString();
    }

    //其他解法
    public static void sort2(String str){
        char[] ch = str.toCharArray();
        Map<Character ,Integer> map = new TreeMap<>();
        for(char c :ch){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        for(Map.Entry<Character, Integer> mapping:list){
            System.out.print(mapping.getKey());
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            //System.out.println(sort(str));
            sort2(str);
        }
        sc.close();
    }
}
