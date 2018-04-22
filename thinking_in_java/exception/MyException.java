package com.ostream.ThinkingInJavaII.exceptions;

/**
 * @Create by ostreamBaba on 18-4-20
 * @描述
 */


public class MyException extends Exception{
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}


class testGlup{
    public static void main(String[] args) {
        try{
            throw new MyException();
        }catch(Exception e){
            //异常抛出却得不到解决 gulp
        }
    }
}