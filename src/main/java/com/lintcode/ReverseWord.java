package com.lintcode;

public class ReverseWord {

    public static String reverse(String word){
        if(word == null || word.length() == 0){return word;}
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length/2; i++){
            char tmp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[i];
            arr[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(char chr : arr){
            sb.append(chr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("you are frank"));
    }
}
