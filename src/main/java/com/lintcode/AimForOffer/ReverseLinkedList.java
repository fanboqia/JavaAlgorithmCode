package com.lintcode.AimForOffer;

import com.lintcode.Utils.ListNode;

public class ReverseLinkedList {

    public ListNode ReverseList(ListNode head) {
        if(head == null){return null;}
        if(head.next == null){return head;}
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}
