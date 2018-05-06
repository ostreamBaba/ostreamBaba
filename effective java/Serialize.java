package com.ostream.effective_java.classes;

import sun.reflect.generics.tree.VoidDescriptor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ Create by ostreamBaba on 18-5-6
 * @ 描述
 */


//对象序列化API
//序列化 将一个对象编码成一个字节流(该对象的序列化) 相反的处理过程被称为反序列化
public class Serialize {
}


abstract class AbstractFoo{
    private int x,y;
    private enum State{NEW,INITIALIZING,INITIALIZED}
    private final AtomicReference<State> init=new AtomicReference<State>(State.NEW);
    public AbstractFoo(int x,int y){
        initialize(x,y);
    }
    protected AbstractFoo(){} //提供一个无参构造器 允许子类实现Serializable接口
    protected final void initialize(int x,int y){
        if(!init.compareAndSet(State.NEW,State.INITIALIZING)){
            throw new IllegalArgumentException("already init");
        }
        this.x=x;
        this.y=y;
        init.set(State.INITIALIZED);
    }
    protected final int getX(){
        checkinit();
        return x;
    }
    protected final int getY(){
        checkinit();
        return y;
    }
    private void checkinit(){
        if(init.get()!=State.INITIALIZED){
            throw new IllegalStateException("uninitialized");
        }
    }
}

final class Foo extends AbstractFoo implements Serializable{

    private static final long serialVersionUID=1856835860946L;

    private void readObject(ObjectInputStream s)throws IOException,ClassNotFoundException{
        s.defaultReadObject();
        int x=s.readInt();
        int y=s.readInt();
        initialize(x,y);
    }
    private void writeObject(ObjectOutputStream s)throws IOException,ClassNotFoundException{
        s.defaultWriteObject();
        s.writeInt(getX());
        s.writeInt(getY());
    }

    public Foo(int x,int y) {
        super(x,y);
    }
}

class Name implements Serializable{
    /**
     * Last name,Must be non-null
     * @ serial
     */
    private final String lastName;
    /**
     * First name,Must be non-null
     * @ serial
     */
    private final String firstName;
    /**
     * Middle name,or null if there is none
     * @ serial
     */
    private final String middleName;
    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    //提供redaObject方法保证约束关系和安全性
}

//逻辑上 字符串序列 物理意义上 它把序列表示成一个双向链表
final class StringList implements Serializable{
    private int size=0;
    private Entry head=null;
    private static class Entry implements Serializable{
        String data;
        Entry next;
        Entry previous;
    }
}

final class StringListI implements Serializable{
    private transient int size=0; //transient 瞬时
    private transient Entry head=null;
    private static class Entry{
        String data;
        Entry next;
        Entry previous;
    }
    public final void add(String s){}
    private void writeObject(ObjectOutputStream s)throws IOException,ClassNotFoundException{
        s.defaultWriteObject();
        s.writeInt(size);
        for(Entry e=head;e!=null;e=e.next){
            s.writeObject(e.data);
        }
    }
    private void readObject(ObjectInputStream s)throws IOException,ClassNotFoundException{
        s.defaultReadObject();
        int numElement=s.readInt();
        for (int i = 0; i < numElement; i++) {
            add((String)s.readObject());
        }
    }
}

