package com.ostream.ThinkingInJavaII.generics;

import java.util.Iterator;
import java.util.Random;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */
//泛型接口

interface Generator<T>{
    T next();
}

class Coffee{
    private static long counter=0;
    private final long id=counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+id;
    }
}
class Latte extends Coffee{}
class Mocha extends Coffee{}
class Cappuccino extends Coffee{}
class Anericano extends Coffee{}

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{
    private Class[] types={
            Latte.class,Mocha.class,Cappuccino.class,Anericano.class
    };
    private static Random random=new Random(47);
    public CoffeeGenerator() {}
    private int size;
    public CoffeeGenerator(int size) {
        this.size = size;
    }
    @Override
    public Coffee next() {
       try{
           return (Coffee)types[random.nextInt(types.length)].newInstance();
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }
    class CoffeeIterator implements Iterator<Coffee>{
        int count=size;
        @Override
        public boolean hasNext() {
            return count>0;
        }
        @Override
        public Coffee next() {
            --count;
            return CoffeeGenerator.this.next();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator=new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }
        for (Coffee c:new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }
}
