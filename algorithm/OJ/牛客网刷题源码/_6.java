package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-7
 * @ √Ë ˆ
 */
public class _6 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode l=root.left;
        TreeNode r=root.right;
        root.left=r;
        root.right=l;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        _6 main=new _6();
        TreeNode treeNode=new TreeNode(8);
        treeNode.left=new TreeNode(6);
        treeNode.left.left=new TreeNode(5);
        treeNode.left.right=new TreeNode(7);
        treeNode.right=new TreeNode(10);
        treeNode.right.left=new TreeNode(9);
        treeNode.right.right=new TreeNode(11);
        main.Mirror(treeNode);
    }


}
