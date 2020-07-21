package com.lintcode.AimForOffer;

import com.lintcode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthOfBST {

    public int getNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //current node + left subtree + right subtree
        return 1+getNodeCount(root.left)+getNodeCount(root.right);
    }

    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        //compare left and right subtree depth
        return Math.max(getDepth(root.left)+1,getDepth(root.right)+1);
    }

    //BFS迭代计算深度（队列计算每一层新加入的节点数量，弹出他们）
    public int getDepthIterativeBFS(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            depth++;
            int levelNodeCount = queue.size();
            while(levelNodeCount-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    //DFS迭代计算深度（队列计算每一层新加入的节点数量，弹出他们）
    public int getDepthIterativeDFS(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            depth++;
            int levelNodeCount = stack.size();
            while(levelNodeCount-- > 0){
                TreeNode node = stack.pop();
                if(node.left != null){
                    stack.add(node.left);
                }
                if(node.right != null){
                    stack.add(node.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        //System.out.println(new DepthOfBST().getNodeCount(n1));
        System.out.println(new DepthOfBST().getDepthIterativeBFS(n1));
    }

}
