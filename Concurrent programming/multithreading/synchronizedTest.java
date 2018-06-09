package com.multithreading;

import org.apache.http.annotation.ThreadSafe;

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
