package com.ostream.effective_java.classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */
//使类和成员可访问性最小 信息隐藏 封装
class Thing{}

public class classActivity {
    public static final Thing[] PRIVATE_VALUE={}; //安全漏洞

    private static final Thing[] PRIVATE_VALUE_SAFE={};
    public static final List<Thing>VALUES= Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUE_SAFE));
    //将公有变私有 增加一个公有的不可变的列表

    public static final Thing[] values(){
        return PRIVATE_VALUE.clone();
    }
    //可以使数组变私有 添加一个公有的方法 返回私有数组的一个备份

    public static void main(String[] args) {

    }
}


