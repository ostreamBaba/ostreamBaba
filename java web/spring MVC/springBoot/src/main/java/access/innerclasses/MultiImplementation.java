package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */


class D{}
abstract class E{}
class Z extends D{
    E makeE(){
        return new E() {};
    }
}
//内部类实现多重继承(抽象类或者具体的类)
public class MultiImplementation {
    static void tasksD(D d){}
    static void tasksE(E e){}

    public static void main(String[] args) {
       Z z=new Z();
       tasksD(z);
       tasksE(z.makeE());
    }
}
