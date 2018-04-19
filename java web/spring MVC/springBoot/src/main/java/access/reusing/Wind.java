package access.reusing;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class Wind extends Instrument{

    public static void main(String[] args) {
        Wind w=new Wind();
        w.tune(w);//upcasting
    }

}
