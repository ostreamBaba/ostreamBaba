package access;

import access.dessert.Cookie;
import org.junit.Test;
import sun.security.provider.Sun;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class Dinner extends Cookie{

    public Dinner() {
        System.out.println("Dinner");
    }

    public void comp(){
        f();  //protected
    }

    public static void main(String[] args) {
        Cookie cookie=new Cookie();
        //cookie.bite(); //不同目录下没有包访问权限
        Dinner dinner=new Dinner();  //会调用基类的构造方法
        dinner.comp();
    }
    //test private
    @Test
    public void test(){
        Sundae s=Sundae.getSundea();
        Sundae s3=Sundae.getSundea();
        System.out.println(s==s3);
        s.print();
        Sundae2 s1=Sundae2.getSundae2();
        Sundae2 s2=Sundae2.getSundae2();
        System.out.println(s1==s2);
    }

}

class Sundae{
    private Sundae(){}
    protected static Sundae getSundea(){
        return new Sundae();
    }
    protected void print(){
        System.out.println("sundae");
    }
}
//singleton
class Sundae2{
    private Sundae2(){}
    private static Sundae2 sundae2=new Sundae2();
    protected static Sundae2 getSundae2(){
        return sundae2;
    }

}