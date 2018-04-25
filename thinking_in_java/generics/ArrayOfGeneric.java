package com.ostream.ThinkingInJavaII.generics;

import java.lang.reflect.Array;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */
//泛型数组

class Generic<T> {}

public class ArrayOfGeneric {
    private static final int SIZE=100;
    private static Generic<Integer>[] generics;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //generics=(Generic<Integer>[])new Object[SIZE]; //被擦除
        generics=(Generic<Integer>[])new Generic[SIZE];  //创建一个被擦除类型的数组 然后对其转型
        System.out.println(generics.getClass().getSimpleName());
        generics[0]=new Generic<Integer>();
        //!generics[1]=new Generic<Double>();
        //!generics[2]=new Object();
    }
}

class GenericArray<T>{
    private T[] array;

    public GenericArray(int size) {
        array=(T[])new Object[size];
    }
    public void put(int index,T item){
        array[index]=item;
    }
    public T get(int index) {
        return array[index];
    }
    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray=new GenericArray<Integer>(10);
        Object[] objects=genericArray.rep();
        System.out.println(objects);
    }
}

class GenericArray2<T>{
    private Object[] objects;
    public GenericArray2(int size) {
        objects=new Object[size];
    }
    public void put(int index,T item){
        objects[index]=item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T)objects[index];
    }
    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[])objects;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> g2=new GenericArray2<Integer>(10);
        for (int i = 0; i < 10; i++) {
            g2.put(i,i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(g2.get(i));
        }
        //warning
        try{
            //rep()只能是Object[]
            Integer[] id=g2.rep();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

//使用标记类型Class<T> 传递到构造器中 以便于从擦除中恢复
class GenericArrayWithTypeToken<T>{
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type,int sz) {
        array=(T[])Array.newInstance(type,sz);
    }
    public void input(int index,T item){
        array[index]=item;
    }
    public T get(int index){
        return array[index];
    }
    public T[] rep(){
        return array;
    }
    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArrayWithTypeToken=new GenericArrayWithTypeToken<Integer>(Integer.class,10);
        Integer[] ia=genericArrayWithTypeToken.rep();
        System.out.println(ia);
    }
}
