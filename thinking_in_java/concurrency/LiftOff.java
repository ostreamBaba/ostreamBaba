package com.ostream.ThinkingInJavaII.concurrency;
/**
 * @Create by ostreamBaba on 18-4-28
 * @描述
 */
public class LiftOff implements Runnable{
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;
    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+")";
    }
    @Override
    public void run() {
        while (countDown-->0){
            System.out.println(status());
            Thread.yield(); //对线程调度器(可以将cpu从一个线程转移到另一个线程)的一种建议
            //声明： 我已经执行完成生命周期中最重要的部分了 此刻正是切换给其他任务执行一段时间的大好时机(可以看到任务换进换出)
        }
    }
}

class MainThread{
    public static void main(String[] args) {
        LiftOff tf=new LiftOff();
        tf.run();
    }
}

class BasicThreads{
    public static void main(String[] args) {
        Thread t=new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for liftOff!");
    }
}

class MoreBasicThread{
    public static void main(String[] args) {
        //线程调度机制是非确定性的 所以运行结果可能不同
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff!!!");
    }
}

