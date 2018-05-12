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


//内部锁synchronized的可重进入特性
class Someclass {
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
        Someclass sc = new Someclass();
        sc.method1();
    }
}
```
