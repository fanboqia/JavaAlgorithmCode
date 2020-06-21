package com.lintcode.HuaWei;

import java.util.Scanner;

public class AddCharBeforeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            str = str.replaceAll("(\\d+)", "\\*$1\\*");
            System.out.println(str);
        }
    }
}
