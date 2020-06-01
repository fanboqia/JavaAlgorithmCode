package com.lintcode;

import com.lintcode.Utils.CommonUtils;
import com.lintcode.Utils.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head){
        if(head == null){return head;}
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(next!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next.next == null){
                next.next = prev;
                return next;
            }
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args){
        CommonUtils.printList(reverseLinkedList(CommonUtils.ArrToList(new int[]{1,2,3})));
    }
}
