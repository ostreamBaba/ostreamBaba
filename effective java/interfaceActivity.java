package com.ostream.effective_java.classes;

import java.util.AbstractList;
import java.util.List;
import java.util.Map;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */

//接口优于抽象类
class Song{}
class AudioClip{}
interface Singer{
    AudioClip sing(Song s);
}
interface SongWriter{
    Song compose(boolean hit);
}
interface SingerSongWriter extends Singer,SongWriter{
    AudioClip strum();
    void actSensitive();
}

public class interfaceActivity {
}

class ListActivity{
    static List<Integer> initArrayAsList(final int[] a){
        if(null==a){
            throw new NullPointerException();
        }
        //骨架实现类
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i]; //自动装箱
            }
            @Override
            public int size() {
                return a.length;
            }
            @Override
            public Integer set(int i, Integer integer) {
                int oldVal=a[i];
                a[i]=integer;
                return oldVal; //自动装箱
            }
        };
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        List<Integer> integerList=initArrayAsList(a);
        System.out.println(integerList.size());
    }
}

//骨架实现类 为了继承的目的而设计的
//抽象类的演变比接口的演变要容易的多 在抽象类中增加新的方法 始终可以增加具体方法 包含了合理的默认实现

abstract class AbstractMapEntry<K,V> implements Map.Entry<K,V>{
    public abstract K getKey();
    public abstract V getValue();
    @Override
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean equals(Object o) {
        if(o==this){
            return true;
        }
        if(!(o instanceof Map.Entry)){
            return false;
        }
        Map.Entry<K,V> arg=(Map.Entry<K,V>)o;
        return equals(getKey(),arg.getKey())&&equals(getValue(),arg.getValue());
    }
    private static boolean equals(Object o1,Object o2){
        return o1==null?o2==null:o1.equals(o2);
    }
    @Override
    public int hashCode() {
        return hashCode(getKey())^hashCode(getValue());
    }
    private static int hashCode(Object obj){
        return obj==null?0:obj.hashCode();
    }
}

//总结： 接口通常是定义允许多个实现的类型的最佳途径(例外： 当演变的容易型比灵活性和功能更为重要的时候 这时候就应该使用抽象类)
//若导出一个重要的接口 坚决考虑同时提供骨架实现类