package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-1
 * @ ÃèÊö
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}


class Solution {
    //Ö´ÐÐË³Ðò
    public static ListNode ReverseList(ListNode head) {
        ListNode preNode=null;
        ListNode nowNode=head;
        while (nowNode!=null){
            ListNode next=nowNode.next;
            nowNode.next=preNode;
            preNode=nowNode;
            nowNode=next;
        }
        return preNode;
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        int length=0;
        ListNode current=head;
        while (current!=null){
            ++length;
            current=current.next;
        }
        if(k>length){
            return null;
        }
        for (int i = 1; i <= length-k; i++) {
            head=head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode( 2);
        listNode.next.next=new ListNode(3);
        ListNode xx=ReverseList(listNode);
    }
}