package access.interfaces.interfaceprocessor;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */

//processor 接口复用
public abstract class StringProcessor implements Processor{

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    abstract public Object process(Object input);

    public static String s="interfaces";

    public static void main(String[] args) {
        Apply.process(new Upcase(),s);
    }

}

class Upcase extends StringProcessor{
    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}
