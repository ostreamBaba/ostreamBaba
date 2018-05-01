package com.ostream.effective_java;

import java.lang.reflect.AccessibleObject;

/**
 * @Create by ostreamBaba on 18-5-1
 * @描述
 */
public class Singleton {
    public static void main(String[] args) {
        Elvis.INSTANCE.leaveBuilding();
    }
}

//享有特权的客户端可以借助AccessibleObject.setAccessible() 通过反射机制调用私有构造器
class Elvis{
    public static final Elvis INSTANCE=new Elvis();
    private Elvis() { }
    public void leaveBuilding(){}
}

//静态工厂方法
class Elvis1{
    private static final Elvis1 INSTANCE=new Elvis1();
    private Elvis1(){}
    public static Elvis1 getInstance(){
        return INSTANCE;
    }
}

enum Elvis2{
    INSTANCE;
    public void leaveTheBuilding(){}
}

class Elvis3{
    private static final Elvis3 INSTANCE=new Elvis3();
    private Elvis3(){}
    public static Elvis3 getInstance(){
        return INSTANCE;
    }
    private Object readResolve(){
        return INSTANCE;
    }
}
