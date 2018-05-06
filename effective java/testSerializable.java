package com.ostream.effective_java.classes;

import java.io.*;

/**
 * @ Create by ostreamBaba on 18-5-6
 * @ 描述
 */

//序列化
//Serialization（序列化）是一种将对象以一连串的字节描述的过程；反序列化deserialization是一种将这些字节重建成一个对象的过程。
/*什么情况下需要序列化
     a）当你想把的内存中的对象保存到一个文件中或者数据库中时候；
     b）当你想用套接字在网络上传送对象的时候；
     c）当你想通过RMI传输对象的时候；*/
public class testSerializable implements Serializable{

    private static final long serialVersionUID=1L;
    private String name="ostreamBaba";
    private int age=24;

    public static void main(String[] args) {
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("mySerial.out"));
            testSerializable ts=new testSerializable();
            os.writeObject(ts);
            os.flush();
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        Deserialize();
    }
    public static void Deserialize(){
        ObjectInputStream is=null;
        try{
           is=new ObjectInputStream(new FileInputStream("mySerial.out"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        testSerializable ts=null;
        try{
            ts=(testSerializable) is.readObject();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("name="+ts.name);
        System.out.println("age="+ts.age);
    }
}
