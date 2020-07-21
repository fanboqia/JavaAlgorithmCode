package com.lintcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils{

    public static ListNode ArrToList(int[] arr){
        ListNode[] arrNode = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            arrNode[i] = node;
        }
        for (int i = 1; i < arrNode.length; i++) {
            arrNode[i - 1].next = arrNode[i];
        }
        return arrNode[0];
    }

    public static void printList(ListNode head){
        if(head == null) return;
        ListNode cur = head;
        List list = new ArrayList<>();
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        for(Object item : list){
            System.out.print(item+"->");
        }
        System.out.println("null");
    }

    public static boolean compareTwoArrays(int arr1[],int arr2[]){
        if(arr1.length != arr2.length){return false;}
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static ListNode ArrToLinkedList(int[] arr){
        if(arr == null || arr.length == 0){return null;}
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i < arr.length; i++){
            ListNode temp = new ListNode(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }

    public static TreeNode ArrToTree(int[] arr){
        if(arr == null || arr.length == 0){return null;}
        TreeNode root = new TreeNode(arr[0]);
        for(int i = 1; i < arr.length; i++){
            insertNode(root,new TreeNode(arr[i]));
        }
        return root;
    }

    private static void insertNode(TreeNode root, TreeNode node){
        if(node.val >= root.val){
            if(root.right == null){
                root.right = node;
            }else {
                insertNode(root.right, node);
            }
        }else{
            if(root.left == null){
                root.left = node;
            }else {
                insertNode(root.left, node);
            }
        }
    }

    public static void printTree(TreeNode root){
        if(root == null){return;}
        printTree(root.left);
        System.out.print(root.val+",");
        printTree(root.right);
    }

}
