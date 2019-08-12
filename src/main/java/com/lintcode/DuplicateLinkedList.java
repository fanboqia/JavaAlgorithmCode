package com.lintcode;

import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class DuplicateLinkedList {

    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        //empty head
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        Set<Integer> set = new HashSet<Integer>();
        while(cur != null){
            //continuous checking 13,13,13,13
            if(set.contains(cur.val)){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                set.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
