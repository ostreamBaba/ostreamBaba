package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ Create by ostreamBaba on 18-8-8
 * @ √Ë ˆ
 */

public class _10 {

    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        System.out.println(new _10().printListFromTailToHead(node));
    }
}
