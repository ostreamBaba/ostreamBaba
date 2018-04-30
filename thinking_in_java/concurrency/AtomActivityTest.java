package com.ostream.ThinkingInJavaII.concurrency;

import java.util.SimpleTimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Create by ostreamBaba on 18-4-30
 * @描述
 */
//原子性和易变性


//一个任务做出的修改 即使在不中断的意义上将是原子性 对其他任务也可能是不可视的(例如 修改只是暂时性地存储在本地处理器的缓存中)
//因此不同的任务对应用的状态存在着不同的视图
//另一方面 同步机制强制在处理系统中 一个任务做出的修改必须在引用中是可视的
//volatile关键字确保了应用中的可视性 如果将一个域声明为volatile的 那么只要对这个域产生了写操作 那么所有的读操作就都可以看到这个修改
//即便使用了本地缓存 情况也确实如此 volatile域也会立即被写入主存中 而读取操作就发生在主存中
//非volatile域的原子操作不必刷新到主存中 因此其他读取该域的任务就不必看到这个新值
//如果多个任务同时访问这个域 那么这个域就应该是volatile的 否则这个域就应该只能经由同步来访问 同步也会导致向主存中刷新
//因此如果一个域完全由synchronized方法或者语法块来防护 那就不必将其设置为是volatile的
//一个任务所做的任何写入操作 对这个任务来说都是可视的 如果它只需要在这个任务内部可视 那么就不需要将其设置为volatile的
public class AtomActivityTest implements Runnable{
    private int i=0;
    public /*synchronized*/ int getValue(){
        return i; //原子性操作 但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取
    }
    //由于i不是volatile 还存在可视性问题
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        AtomActivityTest act=new AtomActivityTest();
        exec.execute(act);
        while (true){
            int val=act.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
    //所以这里getValue()和Increment()必须都是synchronized的 保持同步
}

class SerialNumberGenerator{
    private static volatile int serialNumber=0;
    public static /*synchronized*/ int nextSerialNumber(){  //这里会造成多个任务同时访问(并且涉及一个读操作和一个写操作)
        return serialNumber++;  //not Thread-safe (java递增不是原子性操作)
    }
}
class CircularSet{
    private int[] array;
    private int len;
    private int index=0;
    public CircularSet(int size) {
        array=new int[size];
        len=size;
        for (int i = 0; i < size; i++) {
            array[i]=-1;
        }
    }
    public synchronized void add(int i){
        array[index]=i;
        index=++index%len;
    }
    public synchronized boolean contains(int val){
        for (int i = 0; i < len; i++) {
            if(array[i]==val){
                return true;
            }
        }
        return false;
    }
}
//对基本类型的读取和赋值操作被认为是安全的原子性操作 但是当对象处于不稳定状态时 仍然有可能使用原子性操作来访问他们
//所以还是要遵守同步规则
class SerialNumberChecker{
    private static final int SIZE=10;
    private static CircularSet set=new CircularSet(1000);
    private static ExecutorService exec=Executors.newCachedThreadPool();
    static class SerialChecker implements Runnable{
        @Override
        public void run() {
            while (true){
                int serial=SerialNumberGenerator.nextSerialNumber();  //多个任务竞争序列数 这些任务最终会得到重复的序列数
                if(set.contains(serial)){
                    System.out.println("duplicate: "+serial);
                    System.exit(0);
                }
                set.add(serial);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
        if(args.length>0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("no xxx");
            System.exit(0);
        }
    }
}