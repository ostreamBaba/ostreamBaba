package com.ostream.effective_java.classes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */
public final class StringlengthComparator {
    private StringlengthComparator(){}
    public static final StringlengthComparator INSTANCE=new StringlengthComparator();
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
}
//具体策略类
class StringlengthComparatorI implements Comparator<String>{
    @Override
    public int compare(String t1, String t2) {
        return t1.length()-t2.length();
    }
}
//策略类往往以匿名类声明
class test{
    public static void main(String[] args) {
        String[] a=new String[]{"122133","4562","6289"};
        /*Arrays.sort(a,new Comparator<String>(){
            @Override
            public int compare(String t1,   String t2) {
                return t2.length()-t1.length();
            }
        });*/
        Arrays.sort(a,new StringlengthComparatorI());
        System.out.println(Arrays.asList(a));
    }
}

//Host宿主类
class Host{
    public static class StrLenCmp implements Comparator<String>,Serializable{
        @Override
        public int compare(String s, String t1) {
            return s.length()-t1.length();
        }
    }
    public static final Comparator<String> STRING_LENGTH_COMPARATOR=new StrLenCmp();
}


//一个具体策略只用一次的话 通常使用匿名类来声明和实例化这个具体类
//重复使用的话  他的类通常就要实现为私有的静态成员类 并通过公有的静态final域被导出 其类型为该策略的接口
class test1{
    public static void main(String[] args) {
        String[] a=new String[]{"122133","4562","6289"};
        Arrays.sort(a,Host.STRING_LENGTH_COMPARATOR); //取一个有意义的域名称
        System.out.println(Arrays.asList(a));
    }
}


