package access.dessert;


import static com.ostream.ThinkingInJava.Print.print;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class Cookie {

    public Cookie() {
        print("cookie");
    }
    void bite(){
        System.out.println("bite");
    }
    //提高包访问权限
    protected final void f(){
        System.out.println("cookie.f()");
    }

    public static void main(String[] args) {
        Pie p=new Pie();
        p.f();  //同目录下有包访问权限
    }
}
