package com.ostream.ThinkingInJavaII.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Create by ostreamBaba on 18-4-29
 * @描述
 */
//实现接口可以继承另外一个不同的类 而继承Thread就不可以
public class SelfManager implements Runnable{
    private Thread t=new Thread(this);
    private int countDown=5;

    public SelfManager() {
        t.start();
    }
    @Override
    public String toString() {
        return Thread.currentThread().getName()+"("+countDown+")";
    }
    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManager();
        }
    }
}

// 使用内部类来将线程代码隐藏在类中
class InnerThread1{
    private int countDown=5;
    private Inner inner;
    private class Inner extends Thread{
        public Inner(String name) {
            super(name);
            start();
        }
        @Override
        public void run() {
            try{
                while (true){
                    System.out.println(this);
                    if(--countDown==0){
                       return;
                    }
                    sleep(100);
                }
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        @Override
        public String toString() {
            return getName()+": "+countDown;
        }
    }
    public InnerThread1(String name) {
        inner=new Inner(name);
    }
}

//创建线程的原因就是为了使用Thread的能力 所以不必创建内部类
class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        //在构造器中创建一个匿名的Thread子类 并将其向上转型为Thead引用t
        t = new Thread( name ) {
            public void run() {
                try {
                    while (true) {
                        System.out.println( this );
                        if (--countDown == 0) {
                            return;
                        }
                        sleep( 10 );
                    }
                } catch (InterruptedException e) {
                    System.out.println( e );
                }
            }
            @Override
            public String toString() {
                return t.getName()+": "+countDown;
            }
        };
        t.start();
    }
}

class InnerRunnable1{
    private int countDown=5;
    private Inner inner;
    private class Inner implements Runnable{
        Thread t;
        public Inner(String name) {
            t=new Thread(this,name);
            t.start();
        }
        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(this);
                    if(--countDown==0){
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        @Override
        public String toString() {
            return t.getName()+": "+countDown;
        }
    }
    public InnerRunnable1(String name) {
        inner=new Inner(name);
    }
}

class InnerRunnable2{
    private int countDown=5;
    private Thread t;
    public InnerRunnable2(String name) {
        t=new Thread( new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        System.out.println(this);
                        if(--countDown==0){
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(20);
                    }
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName()+": "+countDown;
            }
        },name );
        t.start();
    }
}

//方法内部创建线程
class ThreadMethod{
    private int countDown=5;
    private Thread t;
    private String name;
    public ThreadMethod(String name) {
        this.name = name;
    }
    //辅助操作
    public void runTask(){
        if(null==t){
            t=new Thread(name){
                @Override
                public void run() {
                    try {
                        while (true){
                            System.out.println(this);
                            if(--countDown==0){
                                return;
                            }
                            sleep(10);
                        }
                    }catch (InterruptedException e){
                        System.out.println(t);
                    }
                }

                @Override
                public String toString() {
                    return t.getName()+": "+countDown;
                }
            };
            t.start();
        }
    }
}


class ThreadVariations{
    public static void main(String[] args) {
        new InnerRunnable1("ir1");
        new InnerRunnable2("ir2");
        new InnerThread1("it1");
        new InnerThread2("it2");
        new ThreadMethod("tm").runTask();
    }
}