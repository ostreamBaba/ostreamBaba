package access.innerclasses.controller;

import access.innerclasses.BigEgg;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */

class Egg2{
    protected class Yolk{
        public Yolk() {
            System.out.println("egg2.yolk");
        }
        public void f(){
            System.out.println("egg2.yolk.f()");
        }
    }
    private Yolk y=new Yolk();
    public Egg2(){
        System.out.println("new egg2");
    }
    public void insertYolk(Yolk y){
        this.y=y;
    }
    public void g(){
        y.f();
    }
}


public class BIgEgg extends Egg2{
    public class Yolk extends Egg2.Yolk{
        public Yolk() {
            System.out.println("bigegg.yolk");
        }
        @Override
        public void f() {
            System.out.println("bigegg.yolk.f");
        }
    }

    public BIgEgg() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2=new BIgEgg();
        e2.g();
    }
}
