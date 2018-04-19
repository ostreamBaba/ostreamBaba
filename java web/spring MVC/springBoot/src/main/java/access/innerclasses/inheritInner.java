package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */

//内部类的继承
class WithInner{
    class Inner{
    }
}

public class inheritInner extends WithInner.Inner{
    public inheritInner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi=new WithInner();
        inheritInner ii=new inheritInner(wi);
    }
}
