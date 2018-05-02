package com.ostream.effective_java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */
public class testSomeThing {

    //不区分大小写排序
    @Test
    public void test1(){
        String[] sourse={"Dad","mother","Month","Fuck","Shut"};
        List<String> strings=Arrays.asList(sourse);
        Collections.sort(strings,String.CASE_INSENSITIVE_ORDER);
        System.out.println(strings);
    }

}

