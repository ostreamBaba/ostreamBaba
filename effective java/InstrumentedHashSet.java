package com.ostream.effective_java.classes;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */

//复合优于继承(复合 转发机制)
public class InstrumentedHashSet<T> extends HashSet<T>{
    private int addCount=0;
    public InstrumentedHashSet() {
    }
    @Override
    public boolean add(T t) {
       ++addCount;
       return super.add(t);
    }
    //@SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        addCount+=collection.size();
        return super.addAll(collection);//addAll会调用add(add被覆盖) 所以又增加了4变成8
        /*Boolean isAdd=false;
        Iterator it=collection.iterator();
        while (it.hasNext()){
            Object result=it.next();
            if(super.add((T)result)){
                isAdd=true;
            }
        }
        return isAdd;*/
    }
    public int getAddCount() {
        return addCount;
    }
    public static void main(String[] args) {
        InstrumentedHashSet<String> s=new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("masiwei","melo","dzknow","psyp"));
        System.out.println(s.getAddCount());
    }
}



//InstrumentedHashSetI实例都把另一个Set实例包装起来了(增加技术功能) 所以InstrumentedHashSetI类也叫作包装类
//decorator模式
final class Dog{}

class InstrumentedHashSetI<T> extends ForwardingSet<T>{
    private int addCount=0;
    public InstrumentedHashSetI(Set<T> s){
        super(s);
    }
    @Override
    public boolean add(T t) {
        addCount++;
        return super.add(t);
    }
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        addCount+=collection.size();
        return super.addAll(collection);
    }
    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSetI<String> s=new InstrumentedHashSetI<String>(new HashSet<String>());
        s.addAll( Arrays.asList("masiwei","melo","dzknow","psyp"));
        System.out.println(s.getAddCount());
        System.out.println(s);
    }
    static void walk(Set<Dog> dogs){
        InstrumentedHashSetI<Dog> isDogs=new InstrumentedHashSetI<Dog>(dogs);
        //将没有计数功能的dogs包装成 有计数功能的isDogs
        //....
    }
    //包装类不适合用在回调框架中
    //在回调框架中 对象把自身的引用传递给其他的对象 用于后续的调用
}
class ForwardingSet<T> implements Set<T>{
    private final Set<T> s;
    public ForwardingSet(Set<T> s) {
        this.s = s;
    }
    @Override
    public void clear() {
        s.clear();
    }
    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }
    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }
    @Override
    public int size() {
        return s.size();
    }
    @Override
    public Iterator<T> iterator() {
        return s.iterator();
    }
    @Override
    public boolean containsAll(Collection<?> collection) {
        return s.containsAll(collection);
    }
    @Override
    public boolean add(T t) {
        return s.add(t);
    }
    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return s.addAll(collection);
    }
    @Override
    public boolean retainAll(Collection<?> collection) {
        return s.retainAll(collection);
    }
    @Override
    public boolean removeAll(Collection<?> collection) {
        return s.removeAll(collection);
    }
    @Override
    public Object[] toArray() {
        return s.toArray();
    }
    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return s.toArray(t1s);
    }
    @Override
    public String toString() {
        return s.toString();
    }
    @Override
    public int hashCode() {
        return s.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        return s.equals( o );
    }
}