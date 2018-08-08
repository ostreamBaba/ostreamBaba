package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Create by ostreamBaba on 18-8-5
 * @ 描述
 */

//从上往下打印二叉树


public class _2 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current=queue.peek();
            result.add(current.val);
            queue.remove();
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode=null;
        ArrayList<Integer> result=PrintFromTopToBottom(treeNode);
        System.out.println(result.toArray());
    }


}
