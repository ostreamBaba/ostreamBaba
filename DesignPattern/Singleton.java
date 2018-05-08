package com.ostream.DesignPattern;

/**
 * @ Create by ostreamBaba on 18-5-9
 * @
 */


public class Singleton {


    //线程不安全问题主要是由于 uniqueInstance 被实例化了多次，如果 uniqueInstance 采用直接实例化的话，就不会被实例化多次，也就不会产生线程不安全问题。
    //但是直接实例化的方式也丢失了延迟实例化带来的节约资源的优势。
    //private static Singleton uniqueInstance=new Singleton();


    private static Singleton uniqueInstance;//延迟初始化
    private Singleton(){}
    //懒汉式 线程不安全
    //以下实现中，私有静态变量 uniqueInstance 被延迟化实例化，这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，从而节约资源。
    //这个实现在多线程环境下是不安全的，如果多个线程能够同时进入 if(uniqueInstance == null) ，那么就会多次实例化 uniqueInstance。
    public static Singleton getUniqueInstance1(){ //静态工厂模式
        if(null==uniqueInstance){ //多个线程进入 被创建多个实例
            uniqueInstance=new Singleton();
        }
        return uniqueInstance;
    }
    //懒汉式 线程安全
    //只需要对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，从而避免了对 uniqueInstance 进行多次实例化的问题。
    //当一个线程进入该方法之后，其它线程试图进入该方法都必须等待，因此性能上有一定的损耗
    public static synchronized Singleton getUniqueInstance2(){
        if(null==uniqueInstance){
            uniqueInstance=new Singleton();
        }
        return uniqueInstance;
    }
}


//双重校验锁-线程安全
//uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那部分的代码进行。也就是说，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。
//双重校验锁先判断 uniqueInstance 是否已经被初始化了，如果没有被实例化，那么才对实例化语句进行加锁。
class Singleton1{
    private volatile static Singleton1 uniqueInstance;
    private Singleton1(){}
    public static Singleton1 getUniqueInstance1(){
        if(uniqueInstance==null){
            synchronized (Singleton1.class){
                if(uniqueInstance==null){
                    uniqueInstance=new Singleton1();
                }
            }
        }
        return uniqueInstance;
    }
}
/*uniqueInstance 采用 volatile 关键字修饰也是很有必要的。
uniqueInstance = new Singleton(); 这段代码其实是分为三步执行。
        1.分配内存空间。
        2.初始化对象。
        3.将 uniqueInstance 指向分配的内存地址。
但是由于 JVM 具有指令重排的特性，有可能执行顺序变为了 1>3>2，这在单线程情况下自然是没有问题。但如果是多线程就有可能 B 线程获得是一个还没有被初始化的对象以致于程序出错。
所以使用 volatile 修饰的目的是禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。*/
