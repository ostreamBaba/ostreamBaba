## 一次性安全发布（one-time safe publication）

* 缺乏同步会导致无法实现可见性，这使得确定何时写入对象引用而不是原语值变得更加困难。在缺乏同步的情况下，可能会遇到某个对象引用的更新值（由另一个线程写入）和该对象状态的旧值同时存在。（这就是造成著名的双重检查锁定（double-checked-locking）问题的根源，其中对象引用在没有同步的情况下进行读操作，产生的问题是您可能会看到一个更新的引用，但是仍然会通过该引用看到不完全构造的对象）。
* 实现安全发布对象的一种技术就是将对象引用定义为 volatile 类型。以下展示了一个示例，其中后台线程在启动阶段从数据库加载一些数据。其他代码在能够利用这些数据时，在使用之前将检查这些数据是否曾经发布过。

```
class Flooble{}
class BackgroundFloobleLoader{
    public volatile Flooble theFlooble;
    public void init(){
        theFlooble=new Flooble(); //this is the only write to theFlooble
		//new Flooble并不是原子操作
    }
}
class SomeOtherClass{
    public void doWork(){
        while (true){
            BackgroundFloobleLoader floobleLoader=new BackgroundFloobleLoader();
            floobleLoader.init();
			// use the Flooble, but only if it is ready
            if(floobleLoader.theFlooble!=null){
                doSomething(floobleLoader.theFlooble);
            }
        }
    }
    private void doSomething(Flooble flooble){}
}
```
