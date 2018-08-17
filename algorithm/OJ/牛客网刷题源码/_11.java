package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-9
 * @ ÃèÊö
 */
public class _11 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode=dfs(
                pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    public TreeNode dfs(int[] pre,int sP,int eP,int[] in,int sI,int eI){
        if(sP>eP||sI>eI){
            return null;
        }
        TreeNode root=new TreeNode(pre[sP]);
        for (int i = sI; i <= eI; i++) {
            if(in[i]==pre[sP]){
                root.left=dfs(pre,sP+1,sP+i-sI,in,sI,i-1);
                root.right=dfs(pre,i-sI+sP+1,eP,in,i+1,eI);
                break;
            }
        }
        return root;
    }

}
