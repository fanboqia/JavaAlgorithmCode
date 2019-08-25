package com.lintcode;

import com.lintcode.Utils.ListNode;
import org.junit.Test;


public class TestDuplicateLinkedList2 {

    //@Test
    public void testDuplicateLinkedList2()
    {
        int[] arr = new int[]{0,1,1,2,2,3};
        ListNode[] arrNode = new ListNode[arr.length];
        for(int i = 0; i < arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            arrNode[i] = node;
        }
        for(int i = 1; i < arrNode.length; i++){
            arrNode[i-1].next = arrNode[i];
        }
        ListNode head = arrNode[0];
        head = DuplicateLinkedList2.deleteDuplicates(head);
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    //@Test
    public void testDuplicateLinkedList21()
    {
        int[] arr = new int[]{0,0,1,1,2,2,3};
        ListNode[] arrNode = new ListNode[arr.length];
        for(int i = 0; i < arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            arrNode[i] = node;
        }
        for(int i = 1; i < arrNode.length; i++){
            arrNode[i-1].next = arrNode[i];
        }
        ListNode head = arrNode[0];
        head = DuplicateLinkedList2.deleteDuplicates(head);
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    //@Test
    public void testDuplicateLinkedList22()
    {
        int[] arr = new int[]{0,0,1,1,2,2,3,3};
        ListNode[] arrNode = new ListNode[arr.length];
        for(int i = 0; i < arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            arrNode[i] = node;
        }
        for(int i = 1; i < arrNode.length; i++){
            arrNode[i-1].next = arrNode[i];
        }
        ListNode head = arrNode[0];
        head = DuplicateLinkedList2.deleteDuplicates(head);
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    @Test
    public void testDuplicateLinkedList23()
    {
        int[] arr = new int[]{0,1,1,1,2,2,3,3,4,7};
        ListNode[] arrNode = new ListNode[arr.length];
        for(int i = 0; i < arr.length;i++){
            ListNode node = new ListNode(arr[i]);
            arrNode[i] = node;
        }
        for(int i = 1; i < arrNode.length; i++){
            arrNode[i-1].next = arrNode[i];
        }
        ListNode head = arrNode[0];
        head = DuplicateLinkedList2.deleteDuplicates(head);
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
