package com.ostream.effective_java.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Create by ostreamBaba on 18-5-5
 * @描述
 */
public class chapter28 {
}


class stack<E>{
    //公共API
    public stack() { }
    public void push(E e){}
    public E pop(){
        return null;
    }
    public boolean isEmpty(){
        return false;
    }
    //参数化类型是不可变的
    public void pushAll(Iterable<? extends E> iterable){
        for(E e:iterable){
            push(e);
        }
    }
    public void popAll(Collection<? super E> collection){
        while (!isEmpty()){
            collection.add(pop());
        }
    }
    public static void main(String[] args) {
        stack<Number> numberStack=new stack<Number>();
        Collection<Object> objectCollection=new ArrayList<Object>();
        numberStack.popAll(objectCollection);
    }
    //PECS

}