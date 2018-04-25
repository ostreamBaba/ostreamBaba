package com.ostream.ThinkingInJava;

import java.util.Iterator;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */

//foreach与迭代器
public class IterableClass implements Iterable<String>{
    protected String[] words="What are u fucking say".split(" ");
    public Iterator<String> iterator() {
        return new Iterator<String>(){
            private int index=0;
            @Override
            public boolean hasNext() {
                return index<words.length;
            }
            @Override
            public String next() {
                return words[index++];
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        IterableClass it=new IterableClass();
        for (String s : it) {
            System.out.println(s);
        }
    }
}
