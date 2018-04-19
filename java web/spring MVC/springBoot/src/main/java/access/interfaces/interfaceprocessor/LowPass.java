package access.interfaces.interfaceprocessor;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
public class LowPass extends Filter {

    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
