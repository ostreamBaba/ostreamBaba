package com.ostream.DesignPattern;

/**
 * @ Create by ostreamBaba on 18-5-17
 * @ 死锁
 */

//1.锁顺序死锁
public class DeadLock {
    private final Object left=new Object();
    private final Object right=new Object();
    public void leftRight(){
        synchronized (left){
            synchronized (right){
                doSomething();
            }
        }
    }

    public void rightLeft(){
        synchronized (right){
            synchronized (left){
                doSomething();
            }
        }
    }
    private void doSomething(){}
}

//动态加锁顺序产生的死锁
class Account{}
class DollorAccount{}
class DynamicDeadLock{
    public void transferMoney(Account fromAccount,Account toAccount,DollorAccount amount){
        synchronized (fromAccount){
            synchronized (toAccount){
                //todo
            }
        }
    }

}
//transferMoney(A,B,10)
//transferMoney(B,A,20)