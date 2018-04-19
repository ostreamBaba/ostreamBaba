package access.polymorphism;

import java.sql.Driver;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */

//缺陷一： private方法(final)无法重写
//缺陷二： 静态w方法无法多态
public class PrivateOverride {


    public static String write(){
       return "po.write()";
    }

    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po=new Drived();
        po.f();
        System.out.println(po.write());
    }

}

class Drived extends PrivateOverride{

    public static String write(){
        return "drived.write()";
    }
    //无法覆盖f()方法
    public void f(){
        System.out.println("public f()");
    }
}
