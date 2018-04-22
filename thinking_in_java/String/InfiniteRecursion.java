package com.ostream.ThinkingInJavaII.string;

import com.ostream.ThinkingInJava.Print;
import com.sun.corba.se.spi.activation._InitialNameServiceImplBase;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */
public class InfiniteRecursion  {
    //递归调用导致StackOverFlow
    //Java每个类从根本上都是继承Object
    @Override
    public String toString() {
        //return "InfiniteRecursion address: "+this+"\n";
        //会将this转换成String类型 调用了this上的toString方法 造成了递归调用
        return "InfiniteRecursion address: "+super.toString()+"\n";
        //return super.toString();
    }
    public static void main(String[] args) {
        InfiniteRecursion ifr=new InfiniteRecursion();
        System.out.println(ifr);
        Object obj=new InfiniteRecursion();
        System.out.println(obj);


        /*----------------------------*/
        int x=5;
        double y=3.14;
        System.out.format("%d, %f\n ",x,y);

        PrintStream out=System.out;
        Formatter f=new Formatter(out);
        f.format("%s, %d, %d","ostream",1,1);

    }

}

//String.format static方法
class DatabaseException extends Exception{
    public DatabaseException(int tId,int qId,String message) {
        super(String.format("(t%d q%d) %s",tId,qId,message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3,7,"failed to write");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
/*
class Hex{
    public static String format(Byte[] bytes){
        StringBuilder sb=new StringBuilder();
        int n=0;
        for(Byte b:bytes){
            if(n%16==0){
                sb.append(String.format("%05x",n));
            }
            sb.append(String.format("%02X", b));
            n++;
            if(n%16==0){
                sb.append("/n");
            }
        }
        sb.append("\n");
        sb.toString();
    }
    public static void main(String[] args)throws Exception {}
}*/
