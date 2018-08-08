package com.dataStructure.nowCoder;

import java.util.Arrays;
import java.util.Stack;

public class _1 {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0,j=0;i<pushA.length;++i){
            st.push(pushA[i]);
            while (!st.empty()&&st.peek()==popA[j]){
                st.pop();
                ++j;
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={4,5,3,1,2};
        System.out.println(IsPopOrder(a,b));
    }
}

