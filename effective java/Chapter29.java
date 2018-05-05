package com.ostream.effective_java.classes;

import java.util.HashMap;
import java.util.Map;

/**
 * @Create by ostreamBaba on 18-5-5
 * @描述
 */

//优先考虑类型安全的异构容器
public class Chapter29 {
}

//类型安全的异构容器
//不可用在不可具体化的类型中
class Favorites{
    //Class<?> 是嵌套的 它不是属于通配符类型的Map的类型 而是他的键的类型 他的键可以是String.class,也可以是Integer.class(异构)
    private Map<Class<?>,Object> favorites=new HashMap<Class<?>,Object>();
    public <T> void putFavorites(Class<T> type, T instance){
        if(null==type){
            throw new NullPointerException("Type is null");
        }
        //favorites.put(type,instance); //放弃了键和值之间的联系 Map并不能把保证每个值的类型和键的类型相同
        favorites.put(type,type.cast(instance)); //让put方法检测instance是否真的是Type所表示的类型的实例
    }
    public <T> T getFavorites(Class<T> type){
        return type.cast(favorites.get(type)); //重新建立了联系 cast方法将对象引用动态地转换成Class对象所表示的类型
    }

    public static void main(String[] args) {
        Favorites f=new Favorites();
        f.putFavorites(String.class,"Java");
        f.putFavorites(Integer.class,1);
        f.putFavorites(Class.class,Favorites.class);
        String fs=f.getFavorites(String.class);
        int is=f.getFavorites(Integer.class);
        Class<?> cs=f.getFavorites(Class.class);
        System.out.printf("%s %d %s",fs,is,cs.getSimpleName());
    }
}
