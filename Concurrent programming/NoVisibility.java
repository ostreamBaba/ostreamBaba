package com.ostream.Concurrent;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-5-12
 * @ 可见性
 */

@NotThreadSafe
public class NoVisibility {
    private static int number;
    private static boolean ready;

    public static class ReadyThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(currentThread().getName()+":"+number);
        }
    }
    //可能情况： 循环不能终结 number打印出0
    public static void main(String[] args) {
        new ReadyThread().start();
        //可能发生重排序
        number=42;
        ready=true;
    }
}

//线程安全的可变整数访问器
@NotThreadSafe
class MutableInteger{
    @GuardedBy("this") private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
@ThreadSafe
class SynchronizedInteger{
    private int value;
    public synchronized int getValue() {
        return value;
    }
    public synchronized void setValue(int value) {
        this.value = value;
    }
}

//内部的可变对象溢出
class UnsafeSates{
    private String[] states=new String[]{"AK","AL","AW"};
    /*public String[] getStates() {
        return states;
    }*/
    //私有states变公有
    public String[] getStates() {
        return states.clone();
    }

    public static void change(String[] args){
        args[2]="US";
    }

    public static void main(String[] args) {
        UnsafeSates unsafeSates=new UnsafeSates();
        String[] unsafe=unsafeSates.getStates();
        change(unsafe);
        //unsafe[2]="AF";
        String[] unsafe1=unsafeSates.getStates();
        System.out.println(Arrays.toString(unsafe1));
    }
}
