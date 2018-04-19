package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-18
 * @描述
 */
interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Imp1 implements Service{
    private Imp1() {
    }

    @Override
    public void method1() {
        System.out.println("imp1 m1");
    }

    @Override
    public void method2() {
        System.out.println("imp1 m2");
    }

    public static ServiceFactory factory=
        new ServiceFactory(){
            @Override
            public Service getService() {
                return new Imp1();
            }
        };
}
class Imp2 implements Service{
    public Imp2() {
    }

    @Override
    public void method1() {
        System.out.println("imp2 m1");
    }

    @Override
    public void method2() {
        System.out.println("imp2 m2");
    }

    public static ServiceFactory factory=
            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new Imp2();
                }
            };
}

//工厂设计模式
public class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory){
        Service s=serviceFactory.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Imp1.factory);
        serviceConsumer(Imp2.factory);
    }
}
