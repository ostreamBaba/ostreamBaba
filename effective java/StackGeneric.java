package com.ostream.effective_java.classes;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Create by ostreamBaba on 18-5-4
 * @描述
 */
public class StackGeneric {
}

//消除Stack创建泛型数组
//法一
class Stack<E>{
    private E[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    @SuppressWarnings("unchecked")
    public Stack() {
        //不能创建不可具体化的数组
        //elements=new E[DEFAULT_INITIAL_CAPACITY];
        //合法 但是类型不安全
        //要确保未受检的转换不会危及到程序的类型安全(相关数组被保存在一个私有的域 永远不会返回到客户端 或者传给其他方法)
        //这个数组保存的唯一元素是push传给的那些元素 类型是E 因此为受检的转换不会有任何危害
        elements=(E[])new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(E e){
        ensureCapacity();
        elements[size++]=e;
    }
    public E pop(){
        if(0==size){
            throw new EmptyStackException();
        }
        E result=elements[--size];
        elements[size]=null;
        return result;
    }
    private void ensureCapacity(){
        if(elements.length==size){
            elements= Arrays.copyOf(elements,size*2+1);
        }
    }
    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        String[] strings=new String[]{"abc","Abc"};
        Stack<String> stack=new Stack<String>();
        for(String s:strings){
            stack.push(s);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().toUpperCase());
        }
    }

}
//法二 将elements域 由E[]改为Object[] 建议第二种(禁止数组类型的未受检转换比禁止标量类型的更加危险)
class StackOther<E>{
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public StackOther() {
        elements=new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(E e){
        ensureCapacity();
        elements[size++]=e;
    }
    public E pop(){
        if(0==size){
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E result=(E)elements[--size];
        elements[size]=null;
        return result;
    }
    private void ensureCapacity(){
        if(elements.length==size){
            elements= Arrays.copyOf(elements,size*2+1);
        }
    }
}