package com.ostream.effective_java;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Create by ostreamBaba on 18-5-2
 * @描述
 */

//消除过期的对象引用
public class Stack {
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public Stack() {
        elements=new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++]=e;
    }
    //这里存在"内存泄露"
    //栈先是增长 然后再收缩 那么栈中弹出来的对象将不会被当做垃圾回收 即使使用栈的程序不再引用这些对象 他们也不会被回收
    //这是因为栈内部维护着这些对象的过期引用(即永远不会再被解除的引用)
    //解决方法: 一旦对象引用已经过期 那么只需要清空这些引用即可
    public Object pop(){
        if(0==size){
            throw new EmptyStackException();
        }
        //return elements[--size];
        Object result=elements[--size];
        elements[size]=null;
        return result;
    }
    private void ensureCapacity(){
        if(elements.length==size){
            elements=Arrays.copyOf(elements,size*2+1);
        }
    }

}
