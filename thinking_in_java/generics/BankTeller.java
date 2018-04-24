package com.ostream.ThinkingInJavaII.generics;

import java.util.*;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */


//匿名内部类与泛型
class Customer {
    private static long counter=0;
    private final long id=counter++;
    Customer(){ }
    @Override
    public String toString() {
        return "Customer "+id;
    }
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
class Teller{
    private static long counter=0;
    private final long id=counter++;
    private Teller() { }

    @Override
    public String toString() {
        return "Teller "+id;
    }
    public static Generator<Teller> generator=new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    }; //不需要创建多个对象
}

public class BankTeller{
    public static void serve(Teller t,Customer c){
        System.out.println(t+" serves "+c);
    }

    public static void main(String[] args) {
        Random random=new Random(47);
        Queue<Customer> q=new LinkedList<Customer>();
        Generators.fill(q,Customer.generator(),5);
        List<Teller> list=new ArrayList<Teller>();
        Generators.fill(list,Teller.generator,5);
        for(Customer c:q){
            serve(list.get(random.nextInt(list.size())),c);
        }
    }
}
