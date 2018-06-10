package com.multithreading;

import org.apache.http.annotation.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Create by ostreamBaba on 18-6-9
 * @ 描述
 */


@ThreadSafe
public class synchronizedTest {

    public synchronized void method(){
        //todo
    }

    public void method1(){
        synchronized (this){
            //todo
        }
    }

    //使用this的锁来执行线程的互斥操作
}

//synchronized静态方法每次只能有一个线程来运行
@ThreadSafe
class someThing{
    static synchronized void method(){
        //todo
    }

    void method1(){
        synchronized (someThing.class){
            //todo
        }
    }

}


class SynchronizedAndLock{

    private ReentrantLock lock=new ReentrantLock();
    //出现return语句锁不会被释放
    void method(){
        lock.lock();
        /*if(条件表达式){
           return;
        }*/
        lock.unlock();
    }

    void method2(){
        lock.lock();
        doMethod(); //抛出异常不会释放锁
        lock.unlock();
    }

    private void doMethod() {
        throw new RuntimeException();
    }

    //使用finally 无论如何都会执行unlock方法
    void method3(){
        lock.lock();
        try {
            //todo
        }finally {
            lock.unlock();
        }
        //finally这种用法就是Before/After模式(事前/事后模式)
    }

    //synchronized方法无论return或者抛出异常一定会释放锁
}
