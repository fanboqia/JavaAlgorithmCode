package com.lintcode;

import com.lintcode.Utils.ListNode;

import javax.swing.text.html.HTMLEditorKit;

public class SwapLinkedListNode {
    /*
    @param head a ListNode

    @return a ListNode
    */
    public static ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            // move to next pair
            head = n1;
        }

        return dummy.next;
    }
}
