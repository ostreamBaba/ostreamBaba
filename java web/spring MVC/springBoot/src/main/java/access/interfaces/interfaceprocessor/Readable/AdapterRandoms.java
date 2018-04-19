package access.interfaces.interfaceprocessor.Readable;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class AdapterRandoms extends RandomDoubles implements Readable{

    private int count;

    public AdapterRandoms(int count) {
        this.count=count;
    }

    @Override
    public int read(CharBuffer charBuffer) throws IOException {
        if(0==--count){
            return -1;
        }
        String result=Double.toString(next())+" ";
        charBuffer.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(new AdapterRandoms(7));
        while (s.hasNext()){
            System.out.println(s.nextDouble()+" "
            );
        }
    }
}
