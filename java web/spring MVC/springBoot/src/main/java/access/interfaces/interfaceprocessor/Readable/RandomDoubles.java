package access.interfaces.interfaceprocessor.Readable;

import java.util.Random;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class RandomDoubles {
    private static Random r=new Random(40);
    public double next(){
        return r.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles r=new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(r.next());
        }
    }
}
