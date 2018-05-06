package com.ostream.effective_java.classes;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ Create by ostreamBaba on 18-5-6
 * @ 描述
 */

class Element{}
//使局部变量的作用域最小化
public class chapter45 {
    public static void main(String[] args) {
        List<Element> elementList=new ArrayList<Element>(Arrays.asList(new Element(),new Element()));
        for(Iterator<Element> it=elementList.iterator();it.hasNext();){
            //todo
        }
    }
}

//for-each优于传统for循环
class chapter46{
    enum Face{ONE,TWO,THREE,FOUR,FIVE}
    enum Suit{SPACE,CLUD}
    public static void main(String[] args) {
        Collection<Face> faces=Arrays.asList(Face.values());
        Collection<Suit> suits=Arrays.asList(Suit.values());
        for(Iterator<Face> i=faces.iterator();i.hasNext();){
                Face it=i.next();
            for(Iterator<Suit> j=suits.iterator();j.hasNext();){
                System.out.println(it+" "+j.next());
            }
        }
        for(Face f:faces){
            for(Suit s:suits){
                System.out.println(f+" "+s);
            }
        }
    }
}

//float double 并不能精确计算
class chapter48{
    public static void testBig(){
        final BigDecimal THE_CENTS=new BigDecimal(".10");
        int count=0;
        BigDecimal funs=new BigDecimal("1.00");
        for(BigDecimal price=THE_CENTS;funs.compareTo(price)>=0;price=price.add(THE_CENTS)){
            ++count;
            funs=funs.subtract(price);
        }
        System.out.println(funs+" "+count);
    }
    public static void main(String[] args) {
        double funs=1.00;
        int intemsBought=0;;
        for (double price=.10;funs>=price;price+=.10) {
            funs-=price;
            ++intemsBought;
        }
        System.out.println(funs+" "+intemsBought);
        testBig();
    }
}


class chapter49{
    static Integer i;
    public static void test(){
        Comparator<Integer> naturalOrder=new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                /*return first<second?-1:(first==second?0:1);*/
                int f=first; //auto unboxing
                int s=second;
                return f<s?-1:(f==s?0:1);
            }
        };
        System.out.println(naturalOrder.compare(new Integer(42),new Integer(42)));
    }


    public static void main(String[] args) {
        /*if(i==42){ //i auto unboxing导致为null抛出空指针异常
            System.out.println("??? ");
        }*/
        test();// 返回1
    }
}


//通过接口引用对象
class chapter52{
    public static void main(String[] args) {
        List<Integer> list=new Vector<Integer>();   //good use interface as type
        //Vector<Integer> vector=new Vector<Integer>(); //bad use calass as type
        list=new ArrayList<Integer>();
    }
}


final class Main{
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int a=cin.nextInt(),b=cin.nextInt();
        System.out.printf("%d",a+b);
    }
}