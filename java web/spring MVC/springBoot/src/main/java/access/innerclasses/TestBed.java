package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */
public class TestBed {
    public void f(){
        System.out.println("f()");
    }
    //java TestBed$Tester
    public static class Tester{ //不会
        public static void main(String[] args) {
            TestBed t=new TestBed();
            t.f();
        }
    }
}
