package com.ostream.ThinkingInJavaII.generics;

/**
 * @Create by ostreamBaba on 18-4-23
 * @描述
 */

class E{
    @Override
    public String toString() {
        return "E: "+super.toString();
    }
}

public class Holder<T> {
    private T t;
    public Holder(T t) {
        this.t = t;
    }
    public void setT(T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }

    public static void main(String[] args) {
        Holder<E> holder=new Holder<E>(new E());
        E e=new E();
        holder.setT(e);
        System.out.println(holder.getT());
    }
}
