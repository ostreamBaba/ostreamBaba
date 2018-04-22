package com.ostream.ThinkingInJavaII.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */

class WrapCheckedExceptiom {
    void throwRuntimeException(int type){
        try {
            switch (type){
                case 0:throw new FileNotFoundException();
                case 1:throw new IOException();
                case 2:throw new RuntimeException("Where am I");
                default:return;
            }
        }catch (Exception e){
            throw new RuntimeException(e); //捕获到的三种异常类型被捕获并封装到了RuntimeException对象里
        }
    }
}
class SomeOtherException extends Exception{}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedExceptiom wce=new WrapCheckedExceptiom();
        wce.throwRuntimeException(3);
        for (int i = 0; i < 4; i++) {
            try{
                if(i<3){
                    wce.throwRuntimeException(i);
                }else{
                    throw new SomeOtherException();
                }
            }catch (SomeOtherException e){
                System.out.println("soe "+e);
            }catch (RuntimeException re){
                try {
                    throw re.getCause();  //捕获并确定是哪种异常
                }catch (FileNotFoundException e){
                    System.out.println("ffe: "+e);
                }catch (IOException e){
                    System.out.println("ie: "+e);
                }catch (Throwable e){
                    System.out.println("throwable: "+e);
                }
            }
        }
    }

}
