package com.ostream.effective_java;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Create by ostreamBaba on 18-5-2
 * @描述
 */

//消除过期的对象引用
public class Stack implements Cloneable{
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

    //clone 若对象中包含的域包含了可变的对象 就不能简单的clone了
    //size域具有正确的值 但是elements域将引用与原始Stack实例相同的数组
    //修改原始实例会破坏被克隆对象中的约束条件
    //clone方法就是另外一个构造器 你必须确保它不会伤害到原始对象 并确保正确地创建被约束对象中的约束条件
    //若elements域是final的话 那么上述方案就不能正常的工作了(clone方法是被禁止给elements域赋新值的)
    @Override
    public Stack clone(){
        try{
            Stack result=(Stack)super.clone();
            result.elements=elements.clone(); //在数组上调用clone返回的数组 其编译时类型与被克隆的类型与被克隆数组的类型相同
            return result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
    private void ensureCapacity(){
        if(elements.length==size){
            elements=Arrays.copyOf(elements,size*2+1);
        }
    }

    public static void main(String[] args) {
        Stack s1=new Stack();
        //Stack s2=s1.clone();
        s1.push(1);
        s1.push("123");
        //System.out.println(s1.pop());
        Stack s2=s1.clone();
        System.out.println(s2.pop());
        s2.push("456");
        //若不调用elements的clone的话
        //s2对elements的操作将影响到s1的elements域(不会影响到size域)
    }
}
