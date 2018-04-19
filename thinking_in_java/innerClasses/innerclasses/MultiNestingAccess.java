package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */

//一个内部类无论被嵌套多少层 都可以访问所有它所嵌入的外围类的所有成员(private)
class MNA{
    private void f(){
        System.out.println("mnaf");
    }
    class A{
        public void g(){
            System.out.println("mnaag");
            f();
        }
        public class B{
            void h(){
                f();
                g();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna=new MNA();
        MNA.A mnaa=mna.new A();
        MNA.A.B mnaab=mnaa.new B();
        mnaab.h();
        mnaa.g();
    }
}
