package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */


class Egg{
    private Yolk y;
    protected class Yolk{
        public Yolk() {
            System.out.println("egg.yolk");
        }
    }
    public Egg(){
        System.out.println("new egg()");
        y=new Yolk();
    }
}

public class BigEgg extends Egg{
    //两个内部类是完全独立的两个实体
    public class Yolk{
        public Yolk() {
            System.out.println("bigegg.yolk");
        }
    }
    public static void main(String[] args) {
        new BigEgg();
    }
}
