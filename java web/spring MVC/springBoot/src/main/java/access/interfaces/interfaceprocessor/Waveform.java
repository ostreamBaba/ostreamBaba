package access.interfaces.interfaceprocessor;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class Waveform {

    private static long counter;
    private final long id=counter++;

    @Override
    public String toString() {
        return "waveform "+id;
    }
}
