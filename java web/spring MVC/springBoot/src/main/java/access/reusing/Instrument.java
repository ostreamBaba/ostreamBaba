package access.reusing;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class Instrument {

    protected void play(){
        System.out.println("play");
    }

    protected void tune(Instrument instrument){
        instrument.play();
    }
}


