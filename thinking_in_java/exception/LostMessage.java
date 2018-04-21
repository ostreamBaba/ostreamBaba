package com.ostream.ThinkingInJavaII.exceptions;

/**
 * @Create by ostreamBaba on 18-4-21
 * @描述
 */

//异常丢失
class VeryImportantException extends Exception{
    @Override
    public String toString() {
        return "vie";
    }
}
class HoMumException extends Exception{
    @Override
    public String toString() {
        return "hme";
    }
}
public class LostMessage {
    void f()throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose()throws HoMumException{
        throw new HoMumException();
    }

    public static void main(String[] args) {
        try{
            LostMessage lm=new LostMessage();
            try {
                lm.f();
            }finally {
                lm.dispose();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
