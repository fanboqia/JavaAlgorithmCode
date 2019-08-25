package com.lintcode;

import com.lintcode.Utils.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 *
 * Example
 * Example 1:
 * 	Input: list1 = null, list2 = 0->3->3->null
 * 	Output: 0->3->3->null
 *
 *
 * Example 2:
 * 	Input:  list1 =  1->3->8->11->15->null, list2 = 2->null
 * 	Output: 1->2->3->8->11->15->null
 */
public class MergeTwoLists {

    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        List<Integer> list = new LinkedList<Integer>();
        ListNode i = l1;
        ListNode j = l2;
        while(i != null && j != null){
            while(i != null && j != null && i.val < j.val){
                list.add(i.val);
                i = i.next;
            }
            while(j != null && i != null && i.val > j.val){
                list.add(j.val);
                j = j.next;
            }
            while(j != null && i != null && i.val == j.val){
                list.add(j.val);
                list.add(j.val);
                i = i.next;
                j = j.next;
            }
        }
        while(i != null){
            list.add(i.val);
            i = i.next;
        }
        while(j != null){
            list.add(j.val);
            j = j.next;
        }

        //正向构造listNode
        ListNode prev = null;
        ListNode cur = null;
        for(int z = 1; z < list.size(); z++){
            if(prev == null){
                prev = new ListNode(list.get(z-1));
                cur = new ListNode(list.get(z));
                prev.next = cur;
            }else{
                cur.next = new ListNode(list.get(z));
                cur = cur.next;
            }
        }
        return prev;
    }
}
