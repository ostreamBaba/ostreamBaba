package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */




interface Counter{
    int next();
}

public class LocalInnerClass {
    private int count=0;
    //local innerClass
    Counter getCounter(final String name){
        //局部内部类不能有访问说明符 不是外围类的一部分
        class LocalCounter implements Counter{
            public LocalCounter() {
                System.out.println("local()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return ++count;
            }
        }
        return new LocalCounter();
    }
    //匿名类
    Counter getCounter2(final String name){
        return new Counter() {
            {
                System.out.println("Counter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return ++count;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass innerClass=new LocalInnerClass();
        Counter c1=innerClass.getCounter("local");
        Counter c2=innerClass.getCounter2("anonymous");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }

}
