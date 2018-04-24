package com.ostream.ThinkingInJavaII.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */

// 利用生成器填充一个Collection
public class Generators {
    public static <T> Collection<T> fill(
            Collection<T> coll,Generator<T> gen,int n){
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
    public static void main(String[] args) {
        Collection<Coffee> coffees=fill( new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for(Coffee c: coffees){
            System.out.println(c);
        }
        Collection<Integer> integers=fill(new ArrayList<Integer>(), new Fibonacci(), 18);
        for (Integer i: integers){
            System.out.println(i);
        }
    }
}
