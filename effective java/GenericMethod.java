package com.ostream.effective_java.classes;

import java.util.*;

/**
 * @Create by ostreamBaba on 18-5-4
 * @描述
 */

//优先考虑泛型方法
public class GenericMethod<E> {
    public static Set Union(Set set1,Set set2){
        Set result=new HashSet(set1);
        result.addAll(set2);
        return result;
    }
    //类型安全
    public static <E> Set<E> UnionGeneric(Set<E> s1,Set<E> s2){
        Set<E> result=new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> set1=new HashSet<String>(Arrays.asList("123","213"));
        Set<String> set2=new HashSet<String>(Arrays.asList("adc","asd"));
        Set<String> set3=UnionGeneric(set1,set2);
        System.out.println(set3);
        Set<Integer> set4=new HashSet<Integer>(Arrays.asList(1,2,3));

        //ClassCastException
        Set set=Union(set1,set4);
        System.out.println(set);
        Iterator it=set.iterator();
        while (it.hasNext()){
            String s= (String) it.next(); //ClassCastException
            System.out.println(s);
        }
    }

}


interface UnaryFunction<T>{
    T apply(T arg);
}
class testGM{
    private static UnaryFunction<Object> IDENTITY_FUNCTION=new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction(){
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }
    public static void main(String[] args) {
        String[] strings={"231","123"};
        UnaryFunction<String> stringUnaryFunction=identityFunction(); //递归类型限制
        for(String s:strings){
            System.out.println(stringUnaryFunction.apply(s));
        }
        Number[] numbers={1,2.0,3L};
        UnaryFunction<Number> numberUnaryFunction=identityFunction();
        for(Number n:numbers){
            System.out.println(numberUnaryFunction.apply(n));
        }
    }
}


//<T extends Comparable<T>> 针对可以与自身比较的每个类型T
class testComparable<E>{
    public static <T extends Comparable<T>> T max(List<T> list){
        Iterator<T> i=list.iterator();
        T result=i.next();
        while (i.hasNext()){
            T t=i.next();
            if(t.compareTo(result)>0){
                result=t;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> integerList=new ArrayList<Integer>(Arrays.asList(12,22,3,123,2111,0));
        int max=max(integerList);
        System.out.println(max);
    }
}
