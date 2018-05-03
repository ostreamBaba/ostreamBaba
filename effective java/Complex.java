package com.ostream.effective_java.classes;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */
// final不可继承
// 不可变对象 只有一种状态 就是创建时候的状态
// 不可变对象可以被自由地共享(实际上没有任何线程会注意到其他线程对于不可变对象的影响)
// 不可变对象为其他对象提供了大量的构建
// 缺点 对于每个不同的值都需要一个单独的对象(可变配套类 String和StringBuilder)
// 此例子仅来演示不可变类
public final class Complex {
    private static final Complex ZERO;
    private static final Complex ONE;
    private static final Complex I;
    static {
        ZERO=new Complex(0,0);
        ONE=new Complex(1,0);
        I=new Complex(0,1);
    }
    //不可变 所以不需要实现clone方法(保护性拷贝)
    public static Complex getZero(){
        return ZERO;
    }
    public static Complex getOne(){
        return ONE;
    }
    public static Complex getI(){
        return I;
    }
    private final double re;
    private final double im;
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public double realPart(){
        return re;
    }
    public double imaginaryPart(){
        return im;
    }
    public Complex add(Complex c){  //不可变性
        return new Complex(re+c.re,im+c.re);
    }
    public Complex subtract(Complex c){
        return new Complex(re-c.re,im-c.re);
    }
    public Complex multiply(Complex c){
        return new Complex(re*c.re-im*c.im,re*c.im+im*c.re);
    }
    public Complex divide(Complex c){
        double tmp=c.re*c.re+c.im*c.im;
        return new Complex((re*c.re+im*c.im)/tmp,
                (re*c.im-im*c.re)/tmp);
    }
    @Override
    public boolean equals(Object o) {
        if(o==this){
            return true;
        }
        if(!(o instanceof Complex)){
            return false;
        }
        Complex c=(Complex)o;
        return Double.compare(re,c.re)==0&&Double.compare(im,c.im)==0;
    }
    @Override
    public int hashCode() {
        int result=17+hashDouble(re);
        result=37*result+hashDouble(im);
        return result;
    }
    private int hashDouble(double val){
        long longBits=Double.doubleToLongBits(val);
        return (int)(longBits^(longBits>>>32));
    }
    @Override
    public String toString() {
        return "("+re+", "+im+")";
    }
}


//类不可以被子类化
//另一种方法 将所有构造器都变成私有的或者包级私有
class Complex_other{
    private final double re;
    private final double im;
    private Complex_other(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public static Complex valueOf(double re,double im){
        return new Complex(re,im);
    }
    public static Complex valueOfPolar(double r,double thera){
        return new Complex(r*Math.cos(thera),r*Math.sin(thera));
    }
}

class Big{
    public static BigInteger safeInstance(BigInteger val){
        if(val.getClass()!=BigInteger.class){
            return new BigInteger(val.toByteArray());
        }
        return val;
    }
}

