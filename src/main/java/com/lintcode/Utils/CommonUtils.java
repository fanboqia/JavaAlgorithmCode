package com.lintcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils{

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

    public static void printList(ListNode head){
        if(head == null) return;
        ListNode cur = head;
        List list = new ArrayList<>();
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        for(Object item : list){
            System.out.print(item+"->");
        }
        System.out.println("null");
    }
}
