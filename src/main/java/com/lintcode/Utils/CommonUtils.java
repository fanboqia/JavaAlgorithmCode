package com.lintcode.Utils;

public class CommonUtils {

    public static ListNode ArrToList(int[] arr){
        ListNode[] arrNode = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            arrNode[i] = node;
        }
        for (int i = 1; i < arrNode.length; i++) {
            arrNode[i - 1].next = arrNode[i];
        }
        return arrNode[0];
    }
}
