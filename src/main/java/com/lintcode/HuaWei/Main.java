package com.lintcode.HuaWei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void parseMatrix(String mat){
        Stack<Character> stack = new Stack<Character>();
        LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
        for (char chr : mat.toCharArray()) {
            if(chr == '['){
                stack.add(chr);
                list.add(new LinkedList<Integer>());
            }
            if(Character.isDigit(chr)){
                stack.add(chr);
            }
            if (chr == ']') {
                while(stack.peek() != '['){
                    list.getLast().addFirst(stack.pop()-'0');
                }
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        String str2 = "[[1, 2],[2, 4]]";
        String str1 = "[1, 2]";
        System.out.println(str1.substring(1,str1.length()-1).split(",\\s*"));
        parseMatrix(str2.substring(1,str2.length()-1));
        System.out.println(Arrays.toString(new int[]{1,2,3}));
        System.out.println(Arrays.toString(new int[][]{{1,2,3},{1,3,4}}));
    }
}
