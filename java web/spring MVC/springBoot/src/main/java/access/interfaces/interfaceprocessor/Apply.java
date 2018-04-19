package access.interfaces.interfaceprocessor;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class Apply {

    public static void process(Processor p,Object s){
        System.out.println("using Processor "+p.name());
        System.out.println(p.process(s));
    }
}
