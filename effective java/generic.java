package com.ostream.effective_java.classes;

import java.util.*;

/**
 * @Create by ostreamBaba on 18-5-4
 * @描述
 */
//List List<Object>
//List有子类型化的规则 List<String>是List的子类型 不是List<Object>的子类型
public class generic {
    public static void main(String[] args) {
        List<String> strings=new ArrayList<String>();
        unsafeAdd(strings,new Integer(12)); //error
        String s=strings.get(0);
        System.out.println(s);
    }
    private static void unsafeAdd(List list,Object o){ //任何元素放进使用原生态类型的集合中 很容易破坏该集合的类型约束条件
        list.add(o);
    }
    private static <E> void safeAdd(List<? super E> list,E e){
        //todo
    }
    /*private static void unsafeAddObject(List<Object> list,Object o){
        list.add(o);
    }*/ //error
    //unsafe
    static int contain1(Set s1,Set s2){
        int result=0;
        for (Object o1:s1){
            if(s2.contains(o1)){
                ++result;
            }
        }
        return result;
    }
    //safe
    static int contain2(Set<?> s1,Set<?> s2){
        int result=0;
        for (Object o1:s1){
            if(s2.contains(o1)){
                ++result;
            }
        }
        return result;
    }

    static void check(Object o){
        if(o instanceof Set){
            Set<?> m=(Set<?>)o;
        }
    }

}
//Set<Object>是个参数化类型 可以包含任意对象类型的一个集合
//Set<?>是一个通配符类型 表示可以只包含某种未知对象类型的一个集合
//Set脱离了泛型系统 不安全

//列表优于数组
class testList{
    public static void main(String[] args) {
        //!List<String>[] stringLists=new List<String>[]{}; //List[] 泛型数组
        //List<Integer> integerList=Arrays.asList(42); //擦除 运行时类型List
        //Object[] objects=stringLists;//协变
        //objects[0]=integerList;
    }
}


final class Stamp{}
final class Coin{}
//错误的操作
final class test3{
    public final Collection collection;
    test3(Collection collection) {
        this.collection = collection;
    }
    public static void main(String[] args) {
        Collection collection=new ArrayList();
        test3 t=new test3(collection);
        //t.collection.add(new Stamp());
        t.collection.add(new Coin());
        Iterator it=t.collection.iterator();
        while (it.hasNext()){
            Stamp stamp=(Stamp)it.next();
            System.out.println(stamp);//类型错误
        }
    }
}
final class test4<E>{
    private final Object[] element;
    private static final int ELEMENT_LENGTH=16;
    private test4() {
        element=new Object[ELEMENT_LENGTH];
    }
    public static test4 getInstance(){
        return new test4();
    }
    public <E> E[] toArray(E[] e){
        if(e.length<ELEMENT_LENGTH){
            @SuppressWarnings("unchecked")
            E[] result=(E[])Arrays.copyOf(element,ELEMENT_LENGTH,e.getClass());
            return result;
        }
        if(e.length>ELEMENT_LENGTH){
            e[ELEMENT_LENGTH]=null;
        }
        return e;
    }
}

//E List<E> List<String> 不可具体化类型 是指其运行时表示法包含的信息比它编译时表示法包含的信息更少的类型

interface Function{
    Object apply(Object o1,Object o2);
}

interface FunctionI<T>{
    T apply(T t1,T t2);
}

class Reduce<T> implements FunctionI<T>{
    @Override
    public T apply(T t1, T t2) {
        return null;
    }
}

final class test5<T>{
    static Object reduce(List list,Function f,Object value){
        synchronized (list){
            Object result=value;
            for (Object o:list){
                result=f.apply(result,o);
            }
            return result;
        }
    }
    //snapshot编译时为E[](可以是String[] Integer[]) 可是在运行时间是Object[] 这样很危险
    static <E> E reduce1(List<E> list,FunctionI<E> f,E value){
        //error E[] snapshot=list.toArray();
        E[] snapshot=(E[])list.toArray(); //Object数组转化成E数组
        E result=value;
        for (E e:snapshot){
            result=f.apply(result,e);
        }
        return result;
    }
    //用列表代替数组
    static <E> E reduce2(List<E> list,FunctionI<E> f,E value){
        List<E> snapshot;
        synchronized (list){
            snapshot=new ArrayList<E>(list);
        }
        E result=value;
        for (E e:snapshot){
            result=f.apply(result,e);
        }
        return result;
    }


    public static void main(String[] args) {
        test5<String> t4=new test5<String>();
        List<String> strings=new ArrayList<String>(Arrays.asList("123","456"));
        String s="+";
        String test=reduce1(strings,new Reduce<String>(),s);
        System.out.println(test);
    }

}


