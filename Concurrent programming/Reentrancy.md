```
//重进入
class Wight{
    public synchronized void doSomething(){

    }
}
class LoggingWeight extends Wight{
    @Override
    public synchronized void doSomething() {
        super.doSomething(); //若内部锁不可重进入 则发生死锁
    }
}


* 在例子中，子类覆盖了父类的synchronized 类型的方法，并调用父类中的方法。程序的执行过程应该是这样的：
    * 1.线程先获取子类LoggingWidget的锁对象；
    * 2.线程进入子类LoggingWidget的doSomething方法中；
*  3.在访问父类方法doSomething时，也要获取调用doSometing方法的对象（即当前的LoggingWidget对象）。
* 就在这一步，如果没有可重入的锁，子类中可能就会产生死锁。因为Widget和LoggingWidget中的dosomething方法都是synchronized 类型的，都会在处理前试图获得LoggingWidget的锁。倘若内部锁不是可重入的，super.doSomething的调用者就永远无法获得Widget的锁。因为锁已经被占用，导致线程永久的延迟，等待着一个永远无法获得的锁。




//内部锁synchronized的可重进入特性
class SomeClass {
    private static final Object LCK_OBJ = new Object();

    public void method1() {
        System.out.println(Thread.currentThread().getName() + " method1");
        synchronized (LCK_OBJ) {
            System.out.println(Thread.currentThread().getName() + " ready in method3");
            method3();
        }
    }
    public void method3() {
        synchronized (LCK_OBJ) {
            System.out.println(Thread.currentThread().getName() + " method3");
        }
    }
    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        sc.method1();
    }
}
```
