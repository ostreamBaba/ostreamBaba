package com.ostream.ThinkingInJavaII.concurrency;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @Create by ostreamBaba on 18-4-29
 * @描述
 */

//join加入一个线程
//一个线程可以在其他线程之上调用join()方法 其效果就是等待一段时间直到第二个线程结束才继续执行
class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int duration) {
        super(name);
        this.duration = duration;
        start();
    }
    @Override
    public void run() {
        try{
            sleep(duration);
        }catch (InterruptedException e){
            //异常被捕获时将清理这个标记 所以这个标志总为假
            System.out.println(getName()+" was interrupted. "+"isInterrupted(): "+isInterrupted());
            return;
        }
        System.out.println(getName()+" has awakeened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    @Override
    public void run() {
        try{
            sleeper.join();
            //sleep(1000);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println(getName()+" join completed");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy=new Sleeper("sleepy",1500);
        Sleeper grumpy=new Sleeper(  "grumpy",1500);
        Joiner j1=new Joiner("j1",sleepy);
        Joiner j2=new Joiner("j2",grumpy); //因为被打断 所以j2执行的快一点 j2挂起 执行完grumpy线程 在执行j2线程
        grumpy.interrupt();
    }
}
