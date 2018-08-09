package com.ThinkingInJava.util;

import java.io.*;

/**
 * @ Create by ostreamBaba on 18-8-8
 * @ 描述
 */

//密码字段为null，说明反序列化时没有从文件中获取到信息。
//1.一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
//2.transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口.
//3.被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。

public class TransientTest {

    public static void main(String[] args) {

        User user=new User();
        user.setUsername("ios");
        user.setPassword("ios");

        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("/home/ios666/Desktop/tansient.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try{
            User.sex="female";
            ObjectInputStream is=new ObjectInputStream(new FileInputStream("/home/ios666/Desktop/tansient.txt"));
            User user1=(User)is.readObject();
            is.close();
            System.out.println(user1.getSex());
            System.out.println(user1.getUsername());
            System.out.println(user1.getPassword());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class User implements Serializable{
    private static final long serialVersionUID = 2373000039971157133L;

    private String username;
    private transient String password;
    transient static String sex="male";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }
}

class ExternallizableTest implements Externalizable{

    private transient String content="可以被序列化";

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        content=(String) objectInput.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternallizableTest et=new ExternallizableTest();
        ObjectOutput output=new ObjectOutputStream(new FileOutputStream(new File("test")));
        output.writeObject(et);
        ObjectInput input=new ObjectInputStream(new FileInputStream(new File("test")));
        et= (ExternallizableTest) input.readObject();
        System.out.println(et.content);
    }
}
class ExternalizableTest implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {

        ExternalizableTest et = new ExternalizableTest();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (ExternalizableTest) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();
    }
}
