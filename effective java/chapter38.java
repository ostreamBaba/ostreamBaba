package com.ostream.effective_java.classes;

import java.math.BigInteger;

/**
 * @Create by ostreamBaba on 18-5-5
 * @描述
 */

//检查参数的有效性
public class chapter38 {

    public BigInteger mod(BigInteger b){
        //设置约束条件 保证有效
        if(b.signum()<=0){
            throw new ArithmeticException("Moduls<=0: "+b);
        }
        return b;
    }
    //私有方法设置断言
    private static void sort(Long[] a,int offset,int length){
        assert a!=null;
        assert offset>=0&&offset<=a.length;
        assert length>=0&&length<=a.length-offset;
    }
    public static void test(){
        sort(null,12,-1);
    }

    public static void main(String[] args) {
        test();
    }
}


