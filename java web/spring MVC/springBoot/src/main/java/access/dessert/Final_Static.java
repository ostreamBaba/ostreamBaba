package access.dessert;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
class Final{
    private int i;
    Final(int i) {
        this.i = i;
    }
}

public class Final_Static {

    private final int it;
    private final Final fi; //空白final 对象引用

    public Final_Static() {
        it=1;
        fi=new Final(12);
    }




}
