package com.ostream.ThinkingInJavaII.generics;

/**
 * @Create by ostreamBaba on 18-4-23
 * @描述
 */


//元组
public class Tuple<A,B> {
    public final A first;  //若想要使用具有不同元素的元组 就需要创建新的Tuple对象
    public final B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }

    public static void main(String[] args) {
        Tuple<Integer, Long> tuple=new Tuple<Integer, Long>(1,2L);
        System.out.println(tuple);
    }
}

class TupleP <A,B,C> extends Tuple<A,B>{
    public final C third;
    public TupleP(A first, B second, C third) {
        super( first, second );
        this.third = third;
    }
    @Override
    public String toString() {
        return "("+first+", "+second+", "+third+")";
    }
    public static void main(String[] args) {
        TupleP<Integer,Long,Double> tupleP=new TupleP<Integer, Long, Double>(1,2L,3.01d);
        System.out.println(tupleP);
    }
}

class TuplePP <A,B,C,D> extends TupleP<A,B,C>{
    public final D fourth;
    public TuplePP(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth=fourth;

    }
    @Override
    public String toString() {
        return "("+first+", "+second+", "+third+", "+fourth+")";
    }
    public static void main(String[] args) {
        TuplePP<Integer,Long,Double,String> tuplePP=new TuplePP<Integer, Long, Double, String>(1,2L,3.01d,"123");
        System.out.println(tuplePP);
    }
}



class TupleTest{
    static TupleP<E, Integer, String> getTupleP(){
        return new TupleP<E, Integer, String>(new E(), 1, "no.1");
    }
    public static void main(String[] args) {
        TupleP<E, Integer, String> t=getTupleP();
        System.out.println(t);
    }
}