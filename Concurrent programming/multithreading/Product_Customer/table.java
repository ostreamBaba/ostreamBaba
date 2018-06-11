package com.multithreading.Product_Customer;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ Channel 通道 位于producer和customer之间 承担用于传递Data(Cake producer生产 customer使用)角色的中转站 通道的任务
 * @ 多--多
 */


//守护安全的Channel角色

//存在中间角色的意义：线程的协调运行需要考虑“放在中间的东西” 线程的互斥处理需要考虑“应该保护的东西”

public class table {
    private final String[] buffer;
    private int tail;//下一次放置蛋糕的位置
    private int head;//下一次取出蛋糕的位置
    private int count;

    public table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    //放置蛋糕
    //throws InterruptedException两层含义： 是花费时间的方法 是可以取消的方法
    public synchronized void put(String cake)throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" puts "+cake);
        while (count>=buffer.length){  //如果 放置蛋糕的数组满了 那么make蛋糕的线程加入condition队列
            wait();
        }
        buffer[tail]=cake;
        tail=(tail+1)%buffer.length;
        ++count;
        notifyAll();  //唤醒 condition队列中的所有线程(包括put cake和take cake 可以继续放置蛋糕和取蛋糕)
    }
    //取出蛋糕
    public synchronized String take()throws InterruptedException{
        while (count<=0){  //当桌子上的蛋糕取完了 把该线程加入condition队列
            wait();
        }
        String cake=buffer[head];
        head=(head+1)%buffer.length;
        --count;
        System.out.println(Thread.currentThread().getName()+" takes "+cake);
        notifyAll();
        return cake;
    }
}
