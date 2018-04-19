package access;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */

public class Chess extends BoardGame{


    public Chess() {
        super(11);
        System.out.println("Chess");
    }

    public static void main(String[] args) {
        Chess c=new Chess();
        c.printf();
    }

    @Override  //表示覆写父类方法
    public void printf() {
        System.out.println(Chess.class);
    }

    //重载
    public void printf(int x) {
        System.out.println(x);
    }
}







