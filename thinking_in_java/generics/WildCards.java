
package com.ostream.ThinkingInJavaII.generics;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Create by ostreamBaba on 18-4-27
 * @描述
 */
class food{}
class Fruit extends food{}
class Apple extends Fruit{}
class Orange extends Fruit{}

public class WildCards {
    //@SuppressWarnings("unchecked")
    static void rawArgs(Holder holder,Object arg){
        //holder本来是泛型 这里被表示出一个原生类型 用set()传递一个object是不安全的 由于是原生类型 任何对象传递给set都会被upcasting为Object
        holder.setT(arg); //warning
        // holder.setT(new WildCards()); //warning
        //! T t=holder.getT(); //没有任何T对象 结果只能是一个Object
        Object object=holder.getT();
        //System.out.println(object);
    }
    static void unboundedArgs(Holder<?> holder,Object arg){
        //! holder.setT(arg); Error
        // 原生Holder将持有任何类型的组合 而Holder<?>将持有具有某种具体类型的同构集合 不能往Holder<?> holder传递Object
        //! T t=holder.getT(); //没有任何T对象 结果只能是一个Object
        Object obj=holder.getT();
    }
    static <T> T exact1(Holder<T> holder){
        T t=holder.getT();
        return t;
    }
    static Holder holder1=new Holder();
    static <T> T exact2(Holder<T> holder,T arg){
        holder.setT(arg);

        T t=holder.getT();
        return t;
    }
    static <T> T wildSubType(Holder<? extends T> holder,T arg){
        //holder.setT(arg); //error
        //T为fruit 那么holder可以是Holder<apple>  //若T为Fruit 那么wildSubType(new ArrayList<Apple>(),new Orange)这种是不允许的
        //!WildCards.<Fruit>wildSubType(new Holder<Apple>(new Apple()),new Orange()); false
        //!WildCards.<Fruit>wildSubType(new Holder<Apple>(new Apple()),new Apple()); true
        T t=holder.getT();
        return t; //Holder<? extends Father>的对象至少是Father
     }
     static <T> void wildSuperTYpe(Holder<? super T> holder,T arg){
         holder.setT(arg);
         //holder可以是持有任何T的基类型容器
         //任何工作于基类的对象都可以多态地作用于导出类(这里值的是T)
         //!T t=holder.getT();
         //因为由holder持有的类型可以是任何超类型 因此唯一安全的类型就是Object
         Object obj=holder.getT();
         // WildCards.<Fruit>wildSuperTYpe(new Holder<food>(new Fruit()),new Fruit());
         // WildCards.<Fruit>wildSuperTYpe(new Holder<Object>(new Fruit()),new Fruit());
         // 上面两种方法都可以
         // 可是 当我们读取的时候,编译器在不知道是什么类型的情况下只能返回Object对象，
         // 因为Object是任何Java类的最终祖先类。但这样的话，元素的类型信息就全部丢失了
     }

    public static void main(String[] args) {
        Holder raw=new Holder<Long>();
        //or:
        raw=new Holder();
        Holder<Long> qualified=new Holder<Long>();
        Holder<?> unbounded=new Holder<Long>();
        Holder<? extends Long> bounded=new Holder<Long>();
        Long lng=1L;
        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);

        unboundedArgs(raw,lng);
        unboundedArgs(qualified,lng);
        unboundedArgs(unbounded,lng);
        unboundedArgs(bounded,lng);


        /* -------------- */
        Object r1=exact1(raw);
        //System.out.println(r1.getClass());
        Long r2=exact1(qualified);
        //System.out.println(r2.getClass());
        Object r3=exact1(unbounded);
        //System.out.println(r3.getClass());
        Long r4=exact1(bounded); //知道至少是Long

        Object r5=exact2(raw,lng);
        //Long r5= (Long)exact2(raw,lng);  //error 此处书中只是warning而已
        Long r6=exact2(qualified,lng);
        //Long r7=exact2(unbounded,lng); //error
        //Long r8=exact2(bounded,lng); //error

        Object r9=wildSubType(raw,lng);
        /*Long r9=(Long)wildSubType(raw,lng); //此处与书中不一样*/
        Long r10=wildSubType(qualified,lng);
        //Object r11=wildSubType(unbounded,lng); //???
        Long r12=wildSubType(bounded,lng);

        wildSuperTYpe(raw,lng);
        wildSuperTYpe(qualified,lng);
        //wildSuperTYpe(unbounded,lng); error
        //wildSuperTYpe(bounded,lng); error

    }


    @Test
    @SuppressWarnings("unchecked")
    public void test(){
        Long test=1L;
        Long t1=(Long) WildCards.<Object>exact2(holder1,test);
        Long t2=WildCards.<Long>exact2(holder1,test);
    }

}
