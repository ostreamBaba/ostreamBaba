package nyoj;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @ Create by ostreamBaba on 18-5-6
 * @ 描述
 */
public class addAB {
    private static int a;
    private static int b;
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            a=cin.nextInt();
            b=cin.nextInt();
            System.out.println(a+b);
        }
       /* a=cin.nextInt();
        b=cin.nextInt();
        System.out.println(a+b);*/
    }
}

class Main{
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        PrintWriter cout=new PrintWriter(System.out);
        int a=cin.nextInt();
        int b=cin.nextInt();
        cout.println(a+b);
        cout.flush();
    }
}