package com.ostream.effective_java;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import java.lang.Comparable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Create by ostreamBaba on 18-5-2
 * @ 描述
 */

//覆盖equals始终是要覆盖hashCode
public class PhoneNumber implements Comparable<PhoneNumber>{
    private volatile int hashCode;
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode,999,"area code");
        rangeCheck(prefix,999,"prefix");
        rangeCheck(lineNumber,9999,"line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short)lineNumber;
    }
    private static void rangeCheck(int arg,int max,String name){
        if(arg<0||arg>max){
            throw new IllegalArgumentException(name+":" +arg);
        }
    }
    @Override
    public boolean equals(Object o) {
        if(o == this){ //自反性
            return true;
        }
        if(!(o instanceof PhoneNumber)){
            return false;
        }
        PhoneNumber pn=(PhoneNumber)o;
        return pn.areaCode==areaCode&&pn.prefix==prefix&&pn.lineNumber==lineNumber;
    }
    /*@Override
    public int hashCode() {
        return 42;
    }
    //覆盖hashCode后 确保了相同的对象总是具有相同的散列码 因此每个对象都被映射到同一个散列桶中 map就退化成了链表*/

    /*@Override
    public int hashCode() {
        int result=17;
        result=31*result+areaCode;
        result=31*result+prefix;
        result=31*result+lineNumber;
        return result;
    }*/
    //lazily initialize 延迟初始化(直到hashCode第一次被调用的时候才被初始化)
    @Override
    public int hashCode() {
        int result=hashCode;
        if(result==0){
            result=17;
            result=31*result+areaCode;
            result=31*result+prefix;
            result=31*result+lineNumber;
        }
        return result;
    }

    //始终要覆盖toString方法
    @Override
    public String toString() {
        return String.format("(%03d)%03d-%04d",areaCode,prefix,lineNumber);
    }

    //协变返回类型
    //目前覆盖方法的返回类型可以是别覆盖方法的返回类型的子类了
    @Override
    public PhoneNumber clone(){
        try{
            return (PhoneNumber) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        //return areaCode<phoneNumber.areaCode?-1:(areaCode==phoneNumber.areaCode?0:-1);
        /*int areacodeDiff=areaCode-phoneNumber.areaCode;
        //注意溢出
        if(areacodeDiff!=0){
            return areacodeDiff;
        }*/
        if(areaCode<phoneNumber.areaCode){
            return -1;
        }
        if(areaCode>phoneNumber.areaCode){
            return 1;
        }
        if(prefix<phoneNumber.prefix){
            return -1;
        }
        if(prefix>phoneNumber.prefix){
            return 1;
        }
        if(lineNumber<phoneNumber.lineNumber){
            return -1;
        }
        if(lineNumber>phoneNumber.lineNumber){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Map<PhoneNumber,String> m=new HashMap<PhoneNumber,String>();
        /*PhoneNumber pn=new PhoneNumber(333,444,5678);
        m.put(pn,"fuck");
        System.out.println(m.get(pn));*/
        m.put(new PhoneNumber(333,444,5678),"tom");
        System.out.println(m.get(new PhoneNumber(333,444,5678)));//hashCode没有被覆盖 所以导致两个实例没有相同的散列码
        System.out.println(m.get(new PhoneNumber(444,333,5678)));
        PhoneNumber pn=new PhoneNumber(333,444,5678);
        System.out.println(pn);
    }
}

//private static final long serialVersionUID = -5365630128856068164L;????