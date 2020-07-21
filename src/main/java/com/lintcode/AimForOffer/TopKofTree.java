package com.lintcode.AimForOffer;

import com.lintcode.Utils.CommonUtils;
import com.lintcode.Utils.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopKofTree {

    public com.lintcode.Utils.TreeNode KthNode(com.lintcode.Utils.TreeNode pRoot, int k){
        if(k < 1 || pRoot == null){return null;}
        PriorityQueue<TreeNode> pq = new PriorityQueue<com.lintcode.Utils.TreeNode>(new Comparator<TreeNode>() {
            @Override
            public int compare(com.lintcode.Utils.TreeNode o1, com.lintcode.Utils.TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        pq = KthNode(pRoot,k,pq);
        if(pq.size() < k){
            return null;
        }
        return pq.poll();
    }

    public PriorityQueue<com.lintcode.Utils.TreeNode> KthNode(com.lintcode.Utils.TreeNode pRoot, int k, PriorityQueue<com.lintcode.Utils.TreeNode> pq)
    {
        if(pRoot == null){return null;}
        if(pq.size() < k){
            pq.offer(pRoot);
        }else{
            com.lintcode.Utils.TreeNode node = pq.peek();
            if(node.val > pRoot.val){
                pq.poll();
                pq.offer(pRoot);
            }
        }
        KthNode(pRoot.left,k,pq);
        KthNode(pRoot.right,k,pq);
        return pq;
    }

    //直接中序遍历就是排好序的，可以找到第K大的
    public com.lintcode.Utils.TreeNode KthNode2(com.lintcode.Utils.TreeNode pRoot, int k){
        if(k < 1 || pRoot == null){return null;}
        int index = 0;
        Stack<TreeNode> stack = new Stack<com.lintcode.Utils.TreeNode>();
        while(pRoot != null || !stack.isEmpty()){
            //先把左边的所有节点放到stack中
            while(pRoot != null){
                stack.add(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            index++;
            if(index == k) return pRoot;
            pRoot = pRoot.right;
        }
        return null;
    }

    //中序遍历递归
    int index = 0; //计数器
    TreeNode KthNode3(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode3(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode3(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

    public static void main(String[] args){
        TreeNode root = CommonUtils.ArrToTree(new int[]{5,3,7,2,4,6,8});
        TopKofTree topKofTree = new TopKofTree();
        CommonUtils.printTree(topKofTree.KthNode3(root,5));
    }
}