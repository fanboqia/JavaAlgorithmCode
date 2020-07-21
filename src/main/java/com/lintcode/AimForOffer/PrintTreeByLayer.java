package com.lintcode.AimForOffer;

import com.lintcode.Utils.CommonUtils;
import com.lintcode.Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintTreeByLayer {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){ return lists;}
        Queue<TreeNode> q1 = new ArrayDeque<TreeNode>();
        Queue<TreeNode> q2 = new ArrayDeque<TreeNode>();
        q1.add(pRoot);
        while(!q1.isEmpty() || !q2.isEmpty()){
            ArrayList<Integer> level1 = new ArrayList<Integer>();
            while(!q1.isEmpty()){
                TreeNode node = q1.poll();
                level1.add(node.val);
                if(node.left != null){
                    q2.add(node.left);
                }
                if(node.right != null){
                    q2.add(node.right);
                }
            }
            if(level1.size() != 0)
                lists.add(level1);
            ArrayList<Integer> level2 = new ArrayList<Integer>();
            while(!q2.isEmpty()){
                TreeNode temp = q2.poll();
                level2.add(temp.val);
                if(temp.left != null){
                    q1.add(temp.left);
                }
                if(temp.right != null){
                    q1.add(temp.right);
                }
            }
            if(level2.size() != 0)
                lists.add(level2);
        }
        return lists;
    }

    public static void main(String[] args){
        Print(CommonUtils.ArrToTree(new int[]{8,6,10,5,7,9,11}));
    }
}
