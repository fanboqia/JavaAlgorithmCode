package com.lintcode.AimForOffer;

import com.lintcode.Utils.CommonUtils;
import com.lintcode.Utils.ListNode;

public class RemoveDuplicateItemsLinkedList {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){return null;}
        ListNode cur = pHead;
        while(cur != null){
            ListNode temp = cur;
            while(temp != null && temp.val == cur.val){
                temp = temp.next;
            }
            cur.next = temp;
            cur = temp;
        }
        return pHead;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,3,4,4,5,6};
        CommonUtils.printList(deleteDuplication(CommonUtils.ArrToLinkedList(arr)));
    }
}
