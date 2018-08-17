package com.dataStructure.nowCoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Create by ostreamBaba on 18-8-11
 * @ √Ë ˆ
 */

public class _14 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int run(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int dept=0;
        while (!queue.isEmpty()){
            ++dept;
            int size=queue.size();
            while (--size>=0){
                TreeNode current=queue.remove();
                if(current.left==null&&current.right==null){
                    return dept;
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }

        }
        return dept;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        System.out.println(run(treeNode));
    }
}
