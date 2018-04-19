package access.interfaces.interfaceprocessor;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class Filter {

    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }

}
