package com.ostream.effective_java.classes;

import java.io.*;
import java.util.Date;

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

//序列化ID 序列化 ID 在 Eclipse 下提供了两种生成策略，一个是固定的 1L，一个是随机生成一个不重复的 long 类型数据（实际上是使用 JDK 工具生成），
//在这里有一个建议，如果没有特殊需求，就是用默认的 1L 就可以，这样可以确保代码一致时反序列化成功。这也可能是造成序列化和反序列化失败的原因，因为不同的序列化id之间不能进行序列化和反序列化。

//序列化前后对象的地址不同了，但是内容是一样的，而且对象中包含的引用也相同。换句话说，通过序列化操作,我们可以实现对任何可Serializable对象的”深度复制（deep copy）"
// ——这意味着我们复制的是整个对象网，而不仅仅是基本对象及其引用。对于同一流的对象，他们的地址是相同，说明他们是同一个对象，但是与其他流的对象地址却不相同。
// 也就说，只要将对象序列化到单一流中，就可以恢复出与我们写出时一样的对象网，而且只要在同一流中，对象都是同一个。


public class testSerializable implements Serializable{

    private static final long serialVersionUID=1L;
    private String name="ostreamBaba";
    private int age=24;

    public static void main(String[] args) {
        //序列化
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
        //反序列化
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

class PeriodSerial implements Serializable{
    private final Date start;
    private final Date end;
    private PeriodSerial(Date start, Date end) {
        if(start.compareTo(end)>0){
            throw new IllegalArgumentException(start+" after "+end);
        }
        this.start=new Date(start.getTime());
        this.end=new Date(end.getTime());
    }
    public static PeriodSerial getInstance(Date start,Date end){
        return new PeriodSerial(start,end);
    }
    public Date getStart() {
        return new Date(start.getTime());
    }
    public Date getEnd() {
        return new Date(end.getTime());
    }
    //Date是可变的
    public static void main(String[] args) {
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("PeriodSerial.out"));
            Date start=new Date();
            Date end=new Date();
            PeriodSerial ps=getInstance(start,end);
            os.writeObject(ps);
            os.flush();
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class BogusPeriod{
    public static void Deserialize(){
        ObjectInputStream is=null;
        try{
            is=new ObjectInputStream(new FileInputStream("PeriodSerial.out"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        PeriodSerial ps=null;
        try{
            ps=(PeriodSerial) is.readObject();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(ps);
    }
    public static void main(String[] args) {
        Deserialize();
    }
}