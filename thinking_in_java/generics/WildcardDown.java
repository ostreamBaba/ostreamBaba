package com.ostream.ThinkingInJavaII.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */

class Human{}


//<? super T> 表示类型下界（Java Core中叫超类型限定）
//表示参数化类型是此类型的超类型（父类型），直至Object;

//super只能添加Father和Father的子类，
//不能添加Father的父类,读取出来的东西只能存放在Object类里

//因为下界规定了元素的最小粒度的下限，实际上是放松了容器元素的类型控制。
//既然元素是Father的基类，那往里存粒度比Father小的都可以。
//出于对类型安全的考虑，我们可以加入Father对象或者其任何子类（如Son）对象
//但由于编译器并不知道List的内容究竟是Father的哪个超类，
//因此不允许加入特定的任何超类（如Human）。而当我们读取的时候，
//编译器在不知道是什么类型的情况下只能返回Object对象，
//因为Object是任何Java类的最终祖先类。但这样的话，元素的类型信息就全部丢失了。
public class WildcardDown {
    public static void main(String[] args) {
        List<? super Father> list=new ArrayList<>();
        list.add(new Father());
        list.add(new Son());
        list.add(new D());
        //! list.add(new Human());
        //! Father f1=list.get(0);
        for(Object o:list){
            System.out.println(o);
        }
    }
}


