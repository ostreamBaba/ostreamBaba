package access.interfaces.interfaceprocessor;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */

//适配器设计模式
class FilterAdapter implements Processor{
    //接受Filter，生成Processor接口对象
    private Filter filter;
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }
    @Override
    public String name() {
        return filter.name();
    }
    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform)input);
    }
}

public class FilterProcessor{

    public static void main(String[] args) {
        Waveform w=new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
    }

}