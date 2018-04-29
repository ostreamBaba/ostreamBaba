package com.ostream.ThinkingInJavaII.concurrency;

import java.io.IOException;

/**
 * @Create by ostreamBaba on 18-4-29
 * @描述
 */
public class UnresponsiveUI {
    private volatile double d=1;
    public UnresponsiveUI() throws Exception{
        while (d>0){
            d=d+(Math.PI+Math.E)/d;
        }
        System.in.read(); //never gets here
    }
}
class ResponsiveUI extends Thread{
    private static volatile double d=1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    @Override
    public void run() {  //把运输放在任务里单独运行 此时就可以在进行运算的同时监听控制台的输入
        while (true){
            d=d+(Math.PI+Math.E)/d;
        }
    }
    public static void main(String[] args) throws Exception {
        //!new UnresponsiveUI(); //must kill process
        new ResponsiveUI();  //把运算程序交给后台
        System.in.read();
        System.out.println(d);

    }
}