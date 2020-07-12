package com.lintcode.HuaWei;

import java.util.Scanner;

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    public void setNext(ListNode next){
        this.next = next;
    }
}

public class LinkedListDelete{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int headVal = sc.nextInt();
            ListNode head = new ListNode(headVal,null);
            for(int i = 0; i < num - 1; i++){
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                if(i == 0){
                    head.next = new ListNode(n1,null);
                }else{
                    ListNode cur = head;
                    while(cur != null){
                        if(cur.val == n2){
                            if(cur.next != null){
                                ListNode temp = cur.next;
                                ListNode node1 = new ListNode(n1,null);
                                cur.next = node1;
                                node1.next = temp;
                                break;
                            }else{
                                cur.next = new ListNode(n1,null);
                                break;
                            }
                        }
                        cur = cur.next;
                    }
                }
            }
            int target = sc.nextInt();
            ListNode cur = head;
            ListNode prev = null;
            while(cur != null){
                if(headVal == target){
                    head =  cur.next;
                    break;
                }
                if(cur.val == target){
                    if(cur.next != null){
                        ListNode temp = cur.next;
                        prev.next = temp;
                        break;
                    }else{
                        prev.next = null;
                        break;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
            ListNode run = head;
            while(run != null){
                System.out.print(run.val+" ");
                run = run.next;
            }
            System.out.println();
        }
        sc.close();
    }
}
