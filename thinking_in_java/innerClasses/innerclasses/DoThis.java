package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class DoThis {

    void f(){
        System.out.println("dothis.f()");
    }
    private class Inner{
        public DoThis outer(){
            return DoThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DoThis di=new DoThis();
        DoThis.Inner dii=di.inner();
        dii.outer().f();
        DoThis.Inner diii=di.new Inner();
    }

}
