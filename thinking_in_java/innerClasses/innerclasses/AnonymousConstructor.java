package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-18
 * @描述
 */

abstract class Base{
    private int i;
    public Base(int i) {
        this.i=i;
        System.out.println("Base custructor.i="+i);
    }
    public abstract void f();
    public int value(){
        return i;
    }
}

public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i) {
            {
                System.out.println("initializar");
            }
            @Override
            public void f() {
                System.out.println("f()");
            }

            @Override
            public int value() {
                return super.value();
            }
        };
    }

    public static void main(String[] args) {
        Base base=getBase(13);//实例初始化+
        base.f();
        System.out.println(base.value());
    }
}
