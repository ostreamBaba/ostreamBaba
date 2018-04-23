package com.ostream.ThinkingInJavaII.generics;

import java.util.LinkedList;

/**
 * @Create by ostreamBaba on 18-4-23
 * @描述
 */
public class LinkedStack<T> {

    private static class Node<U>{
        U item;
        Node<U> next;
        public Node() {
            item=null;
            next=null;
        }
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        public boolean end(){
            return item==null&&next==null;
        }
    }
    private Node<T> top=new Node<T>();
    public void push(T item){
        top=new Node<T>(item, top);
    }
    public T Pop(){
        T res=top.item;
        if(!top.end()){
            top=top.next;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedStack<String> list=new LinkedStack<String>();
        for (String s:"what are you fucking say".split("t\\W+")) {
            list.push( s );
        }
        String s;
        while ((s=list.Pop())!=null){
            System.out.println(s);
        }
    }

}
