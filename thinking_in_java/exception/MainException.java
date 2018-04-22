package com.ostream.ThinkingInJavaII.exceptions;

import java.io.FileInputStream;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */

//把异常传给控制台
public class MainException {
    public static void main(String[] args)throws Exception{
        FileInputStream file=new FileInputStream("/home/ios666/workspace/springBoot/src/main/java/com/ostream/ThinkingInJavaII/exceptions/MainException.java");
        file.close();
    }
}

class IDontKnowWhatToDoWithThisCheckedException extends Exception{}

class MainExceptionI {
    public static void main(String[] args){
        try {
            //Useful
            throw new IDontKnowWhatToDoWithThisCheckedException();
        }catch (IDontKnowWhatToDoWithThisCheckedException e){
            throw new RuntimeException();
            //不想异常被吞
        }
    }
}
