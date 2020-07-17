package com.lintcode.AimForOffer;

import com.lintcode.Utils.ListNode;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

//思路：
//设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，
// 一定相遇于环中某点(结论1)。接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，
public class FindCycleStartPointLinkedList {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){return null;}
        ListNode slow = pHead;
        ListNode fast = pHead;
        boolean isCyclic = false;
        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCyclic = true;
                break;
            }
        }
        if(!isCyclic){
            return null;
        }
        slow = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
