package com.ostream.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @ Create by ostreamBaba on 18-5-7
 * @ 描述
 */
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
