package com.ostream.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @ Create by ostreamBaba on 18-5-7
 * @ 描述
 */

//添加参数-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后分析
public class OutOfMemoryError {
    static class OOMObject{
    }
    public static void main(String[] args) {
        List<OOMObject> objectList=new ArrayList<OOMObject>();
        while (true){
            objectList.add(new OOMObject());
        }
    }
}
