package com.lintcode.AimForOffer;

import com.lintcode.Utils.CommonUtils;
import com.lintcode.Utils.ListNode;

public class MergeSortedLinkedList {
    //递归版本
    public static ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            head.next = merge(list1.next,list2);
        }else{
            head = list2;
            head.next = merge(list1,list2.next);
        }
        return head;
    }

    //非递归版本
    public static ListNode mergeIterative(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null){
            cur.next = list2;
        }
        if(list2 == null){
            cur.next = list1;
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode p1 = CommonUtils.ArrToLinkedList(new int[]{1,1,2,3});
        ListNode p2 = CommonUtils.ArrToLinkedList(new int[]{1,1});
        CommonUtils.printList(p1);
        CommonUtils.printList(p2);
        ListNode res = mergeIterative(p1,p2);
        CommonUtils.printList(res);
    }
}
