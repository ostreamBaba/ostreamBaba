package com.dataStructure.nowCoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ Create by ostreamBaba on 18-8-2
 * @ 描述 单调栈
 */

// 给定一段区间 求 最小值的最大区间
public class SimpleStack {

    static class node{
        int val;
        int l;
        int r;
    }

    public static void main(String[] args) {
        Stack<node> st=new Stack<node>();
        Scanner cin=new Scanner(System.in);
        long t=cin.nextInt();
        node[] nodes=new node[(int) t];
        for (int i = 0; i < t; i++) {
            nodes[i]=new node();
            nodes[i].val=cin.nextInt();
        }
        for (int i = 0; i < t; i++) {
            nodes[i].l=i;
            while (!st.empty()&&st.peek().val>nodes[i].val){
                st.peek().r=i-1;
                nodes[i].l=st.peek().l;
                st.pop();
            }
            st.push(nodes[i]);
        }
        int n=(int)t-1;
        while (!st.empty()){
            st.peek().r=n;
            st.pop();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(i+": val="+nodes[i].val+", l="+nodes[i].l+", r="+nodes[i].r);
        }
    }

}