package com.multithreading.SingleThreadedExecution.safe;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.annotation.ThreadSafe;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 使用Single Threaded Execution模式(不存在数据竞争)
 */

@ThreadSafe
public class Gate {
    private int count=0;
    private String name="Nobody";
    private String address="NoWhere";

    //保护了name address count三个字段 确保这三个字段不被多个线程访问
    public synchronized void pass(String name, String address) {
        this.name = name;
        this.address = address;
        ++count;
        check(); //check方法没有加锁 是因为check被设为私有 该类外部无法访问该方法
    }

    //加锁
    @Override
    public synchronized String toString() {
        return "No."+count+": "+name+", "+address;
    }

    private void check() {
        if(name.charAt(0)!=address.charAt(0)){
            System.out.println("***BROKEN***"+toString());
        }
    }

    public static void main(String[] args) {
        Gate gate=new Gate();
        gate.check();
    }
}
