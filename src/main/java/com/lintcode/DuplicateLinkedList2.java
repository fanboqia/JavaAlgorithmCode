package com.lintcode;

import java.util.*;

public class DuplicateLinkedList2 {

    /**
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        //empty head
        if(head == null){
            return head;
        }
        //traverse list, count ocurrence times
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        ListNode cur = head;
        while(cur != null){
            if(map.containsKey(cur.val)){
                map.put(cur.val,map.get(cur.val)+1);
            }else{
                map.put(cur.val,1);
            }
            cur = cur.next;
        }
        ListNode node = null;
        ListNode prev = head;
        List<ListNode> list = new ArrayList<ListNode>();
        Set<Integer> keySet = map.keySet();
        boolean isNewHead = false;
        int i  = 0;
        int size = keySet.size();
        for(Integer key : keySet){
            size--;
            if(map.get(key) > 1 && key == head.val){
                isNewHead = true;
            }
            if(map.get(key) > 1 ){
                i++;
            }
            if(map.get(key) == 1){
                node = new ListNode(key);

                if(isNewHead){
                    prev = node;
                    isNewHead = false;
                    continue;
                }

                if(head.val == key){
                    continue;
                }

                if(size == 0) {
                    prev.next = node;
                    break;
                }

                if(list.size() != 0 && list.get(list.size()-1) != null){
                    list.get(list.size()-1).next = node;
                }
                list.add(node);
            }
        }
        if(keySet.size() == i){
            return null;
        }
        return prev;
    }
}
