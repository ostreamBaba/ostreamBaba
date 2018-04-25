package com.ostream.ThinkingInJavaII.generics;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */



public class Holder1<T> {
    private T value;
    public Holder1() { }
    public Holder1(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        return value.equals(o);
    }
    public static void main(String[] args) {
        Holder1<Son> sonHolder=new Holder1<Son>(new Son());
        Son s=sonHolder.getValue();
        sonHolder.setValue(s);
        //!Holder<Father> fatherHolder=sonHolder;
        Holder1<? extends Father> holder=sonHolder;
        Father f=holder.getValue(); //只返回一个Father
        System.out.println(f);
        s=(Son) holder.getValue();
        /*System.out.println(s.getClass());*/
        try{
            D d=(D)holder.getValue();
        }catch (Exception e){
            //! holder.setT(new Son());
            System.out.println(e);
        }
        System.out.println(holder.equals(s));
    }
}
