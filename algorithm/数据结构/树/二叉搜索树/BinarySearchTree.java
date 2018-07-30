package com.dataStructure.tree.BinaryTree;


/**
 * @ Create by ostreamBaba on 18-7-29
 * @ 描述
 */

public class BinarySearchTree {

    public TreeNode root;

    public BinarySearchTree(int treeDate) {
        root=new TreeNode(treeDate);
    }

    public BinarySearchTree() { }

    //二叉树插入部分 使用递归
    public void buildByRecursion(TreeNode currentNode, int treeDate) {
        if(root==null){
            root=new TreeNode(treeDate);
            root.parent=null;
            return;
        }

        if(treeDate<currentNode.threeDate){
            if(currentNode.leftChildNode!=null){
                buildByRecursion(currentNode.leftChildNode,treeDate);
            }else {
                currentNode.leftChildNode=new TreeNode(treeDate);
                currentNode.leftChildNode.parent=currentNode;
            }
        }else{
            if(currentNode.rightChildNode!=null){
                buildByRecursion(currentNode.rightChildNode,treeDate);
            }else{
                currentNode.rightChildNode=new TreeNode(treeDate);
                currentNode.rightChildNode.parent=currentNode;
            }
        }
    }

    public void buildByIteration(TreeNode currentNode,int treeDate){
        if(root==null){
            root=new TreeNode(treeDate);
            root.parent=null;
            return;
        }

        //注意 不能判断currentNode==null 因为本身已经不指向原来的对象了
        while (true){
            if(treeDate<currentNode.threeDate){
                if(currentNode.leftChildNode!=null) {
                    currentNode = currentNode.leftChildNode;
                }else{
                    currentNode.leftChildNode=new TreeNode(treeDate);
                    currentNode.leftChildNode.parent=currentNode;
                    return;
                }
            }else{
                if(currentNode.rightChildNode!=null) {
                    currentNode = currentNode.rightChildNode;
                }else {
                    currentNode.rightChildNode=new TreeNode(treeDate);
                    currentNode.rightChildNode.parent=currentNode;
                    return;
                }
            }
        }
    }

    //查询二叉搜索树
    public boolean search(TreeNode currentNode,int date){
        if(currentNode==null){
            throw new IllegalArgumentException("不存在该节点");
        }
        if(currentNode.threeDate==date){
            return true;
        }
        if(date<currentNode.threeDate){
            return search(currentNode.leftChildNode,date);
        }else{
            return search(currentNode.rightChildNode,date);
        }
    }

    //迭代版本
    public TreeNode searchIterative(TreeNode currentNode,int date){
        while (true){
            if(currentNode==null){
                throw new IllegalArgumentException("不存在该节点");
            }
            if(currentNode.threeDate==date){
                break;
            }
            if(date<currentNode.threeDate){
                currentNode=currentNode.leftChildNode;
            }else{
                currentNode=currentNode.rightChildNode;
            }
        }
        return currentNode;
    }

    //查找最大关键字元素 --一直找right孩子直至为null
    public TreeNode findMax(){
        TreeNode currentNode=root;
        while (currentNode.rightChildNode!=null){
            currentNode=currentNode.rightChildNode;
        }
        return currentNode;
    }

    //查找最小关键字元素 --一直查找left孩子直至null
    public TreeNode findMin(){
        TreeNode currentNode=root;
        while (currentNode.leftChildNode!=null){
            currentNode=currentNode.leftChildNode;
        }
        return currentNode;
    }

    //递归版本
    public TreeNode findMinIterative(TreeNode node){
        TreeNode currentNode=node;
        if(node.leftChildNode!=null){
            currentNode=findMinIterative(node.leftChildNode);
        }
        return currentNode;
    }

    //递归版本
    public TreeNode findMaxIterative(TreeNode node){
        TreeNode currentNode=node;
        if(node.rightChildNode!=null){
            currentNode=findMaxIterative(node.rightChildNode);
        }
        return currentNode;
    }

    //查找后继
    //情况1： 如果x节点的右子树不为空 那么x的后继y的就是x的的右子树中的最左节点
    //情况2： 如果x节点的右子树为空 向上寻找父亲节点 若父亲节点的左子树等于当前节点 那么该父亲节点就是x的后继
    public TreeNode getNext(TreeNode node){

        if(node==null){
            throw new IllegalArgumentException("该节点不合法");
        }

        if(node.rightChildNode!=null){
            return findMinIterative(node.rightChildNode);
        }

        TreeNode y=node.parent;
        while (y!=null&&y.leftChildNode!=node){
            node=y;
            y=node.parent;
        }

        if(y==null){
            throw new IllegalArgumentException("该节点没有后继节点");
        }

        return y;
    }

    //寻找前驱 与后继 相反
    //情况1： 如果x的左子树不为空 那么x的前驱y就是x的左子树的最右节点
    //情况2： 如果x的左子树为空 向上寻找父亲节点 若父亲节点的右子树等于当前节点 那么该父亲节点就是x的前驱
    public TreeNode getPre(TreeNode node){
        if(node==null){
            throw new IllegalArgumentException("该节点不合法");
        }
        if(node.leftChildNode!=null){
            return findMaxIterative(node.leftChildNode);
        }

        TreeNode y=node.parent;
        while (y!=null&&y.rightChildNode!=node){
            node=y;
            y=node.parent;
        }

        if(y==null){
            throw new IllegalArgumentException("该节点没有前驱节点");
        }

        return y;
    }

    //移动子树
    //用一棵以v为根的子树 替换 一棵以u为根的子树
    public void transplant(BinarySearchTree binarySearchTree,TreeNode u,TreeNode v){
        if(u.parent==null){  //当u为T的树根的情况
            binarySearchTree.root=v;
        }else if(u==u.parent.leftChildNode){
            u.parent.leftChildNode=v;
        }else if(v==v.parent.rightChildNode){
            u.parent.rightChildNode=v;
        }
        if(v!=null){
            v.parent=u.parent;
        }
    }

    //删除节点
    public void delete(BinarySearchTree binarySearchTree,TreeNode deleteNode){

        if(deleteNode.leftChildNode==null){ //没有左孩子(有右孩子或者NIL)
            transplant(binarySearchTree,deleteNode,deleteNode.rightChildNode);
        }else if(deleteNode.rightChildNode==null){ //没有右孩子(有左孩子或者NIL)
            transplant(binarySearchTree,deleteNode,deleteNode.leftChildNode);
        }else{
            TreeNode y=getNext(deleteNode); //找z的后继
            //两种情况：y是z的右子树 y不是z的右子树

            // y替换y的右子树 后继节点至多只有一个孩子节点(右孩子或者NIL)
            if(y.parent!=deleteNode){
                transplant(binarySearchTree,y,y.rightChildNode);
                //并将y变成z的右子树的双亲节点
                y.rightChildNode=deleteNode.rightChildNode;
                y.rightChildNode.parent=y;
            }

            //将y的左子树替换成z的左子树 并将z替换成y
            y.leftChildNode=deleteNode.leftChildNode;
            y.leftChildNode.parent=y;
            transplant(binarySearchTree,deleteNode,y);
        }

/*
        //若删除节点z的左右孩子节点为空 直接删除节点 并修改z的父节点 用NIL作为孩子来替换z
        if(deleteNode.leftChildNode==null&&deleteNode.rightChildNode==null){
            if(z.leftChildNode==deleteNode){
                z.leftChildNode=null;
            }else{
                z.rightChildNode=null;
            }
        }else {
            if(deleteNode.leftChildNode!=null&&deleteNode.rightChildNode==null){
                if(z.leftChildNode==deleteNode){
                    z.leftChildNode=deleteNode.leftChildNode;
                }else{
                    z.rightChildNode=deleteNode.leftChildNode;
                }
            }else if(deleteNode.leftChildNode==null){
                //即deleteNode.rightChildNode!=null
                if(z.leftChildNode==deleteNode){
                    z.leftChildNode=deleteNode.rightChildNode;
                }else{
                    z.rightChildNode=deleteNode.rightChildNode;
                }
            }else{ //找后继
                TreeNode nextNode=getNext(deleteNode);
                if(nextNode==deleteNode.rightChildNode){ //如果后继不是删除节点的右子树(后继节点左子树一定为NULL)
                    nextNode.leftChildNode=deleteNode.leftChildNode;
                    if(z.leftChildNode==deleteNode){
                        z.leftChildNode=nextNode;
                    }else{
                        z.rightChildNode=nextNode;
                    }
                }else{
                    //用z的后继y 占据树中z的位置
                    nextNode.parent=nextNode.rightChildNode;//用后继节点y自己的右孩子x来替换y 并置y为r的双亲


                    nextNode.leftChildNode=deleteNode.leftChildNode; //让后继节点y代替为他的右子树
                    nextNode.rightChildNode=deleteNode.rightChildNode; //后继节点成为r(z的右子树)的双亲节点

                    if(z.leftChildNode==deleteNode){
                        z.leftChildNode=nextNode;
                    }else{
                        z.rightChildNode=nextNode;
                    }
                }
            }*/
    }


    public static void main(String[] args) {
        int[] treeNode=new int[]{
                5,4,9,7,8
        };
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        for (int i = 0; i < treeNode.length; i++) {
            //binarySearchTree.buildByRecursion(binarySearchTree.root,treeNode[i]);
            binarySearchTree.buildByIteration(binarySearchTree.root,treeNode[i]);
        }
        /*TreeNode findNode=binarySearchTree.search(binarySearchTree.root,2);
        TreeNode findNode1=binarySearchTree.searchIterative(binarySearchTree.root,5);
        System.out.println(findNode.rightChildNode.threeDate);
        System.out.println("最大元素： "+binarySearchTree.findMax().threeDate);
        System.out.println("最小元素： "+binarySearchTree.findMin().threeDate);*/

        boolean isExist=binarySearchTree.search(binarySearchTree.root,5);
        System.out.println(isExist);

        /*int data=6;
        System.out.println("后继： "+
                binarySearchTree.getNext(binarySearchTree.searchIterative(binarySearchTree.root,data))
                        .threeDate);

        System.out.println("前驱： "+
                binarySearchTree.getPre(binarySearchTree.searchIterative(binarySearchTree.root,data))
                        .threeDate);*/


        binarySearchTree.delete(binarySearchTree,binarySearchTree.searchIterative(binarySearchTree.root,5));
    }

}
