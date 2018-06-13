package com.multithreading.ThreadPerMessage;

import java.util.concurrent.*;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ Thread-Per-Message 每个消息一个线程(为每个命令或者请求分配一个新的线程) 消息的委托端和执行端是不同的线程
 */

/*
    Thread-Per-Message模式

    提高响应性 缩短延迟时间(该模式能够提高与Client角色对应的Host角色的响应性 降低延迟时间--尤其是handle操作非常耗时间 或者handle操作需要等待输入/输出时)
    缺点： 启动线程会花费时间 想要提高响应性时 考虑使用该模式取决于handle处理花费的时间和线程启动话费时间的均衡

    适合操作顺序没有要求时(该模式下 handle方法并没有按照request方法调用的顺序来执行)

    适用于不需要返回值

    应用于服务器 服务器本身线程去接受客户端的请求 而这些请求的实际处理是交给其他线程来执行 服务器本身的线程则返回 去等待客户端的其他请求

    调用方法+启动线程-->发送消息

 */

public class Main {
    public static void main(String[] args) {
        //Client 委托人
        System.out.println("main BEING");
        /*Host host=new Host();*/
        /*Host1 host=new Host1( new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        } );*/
        Host1 host=new Host1( Executors.defaultThreadFactory());
        //Executors.defaultThreadFactory() 可以获取当前默认设置的ThreadFactory对象
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("main END");
    }
}

class Main1{
    public static void main(String[] args) {
        System.out.println("main BEING");
        Host2 host=new Host2(new Executor(){
            @Override
            public void execute(Runnable runnable) {
                new Thread(runnable).start();
            }
        });
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("main END");
    }
}

class Main2{
    public static void main(String[] args) {
        System.out.println("main BEING");
        //使用ExecutorService对象来创建Host对象
        //Executors.newCachedThreadPool方法会创建 可复用线程型ExecutorService对象
        //虽然我们使用了Executor进行了抽象化 可最终还是要自己手动执行new Thread{..}
        //可是仔细想想并不是每次都必须创建线程 只要遵循Executor借口 我们可以使用 "会复用那些处理执行结束后空闲下来的线程" 的类--ExecutorService
        ExecutorService executorService=Executors.newCachedThreadPool();
        Host2 host=new Host2(executorService);
        try{
            host.request(10,'a');
            host.request(20,'b');
            host.request(30,'C');
        }finally {
            executorService.shutdown();
        }
        System.out.println("main END");
    }
}

class Main3{
    public static void main(String[] args) {
        System.out.println("main BEING");
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(5);//5表示无工作时也会一直持有的线程个数
        Host3 host=new Host3(scheduledExecutorService);
        try{
            host.request(10,'a');
            host.request(20,'b');
            host.request(30,'c');
        }finally {
            scheduledExecutorService.shutdown();
        }
        System.out.println("main END");
    }
}