package access.dessert;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class Pie extends Cookie{


    public Pie(){
        System.out.println("fuck");
    }


   /* @Override
    protected void f(){
        System.out.println("Pie()");//覆写父类的f方法
        super.f();
    }*/

    /*加上final f()不可被覆盖*/
    protected void f(int x){
        System.out.println(x);
        super.f();
    }

    public static void main(String[] args) {
        Cookie.main(args);
        new Pie().f(2);
    }

}
