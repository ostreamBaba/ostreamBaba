package access.polymorphism;

import static com.ostream.ThinkingInJava.Print.print;

/**
 * @Create by ostreamBaba on 18-4-17
 * @描述
 */
abstract class Instrument{
    /*void play(Note n){
        print("instrument.play() "+n);
    }*/
    abstract void play(Note n);
    String what(){
        return "instrument";
    }
    abstract void adjust();
    /*void adjust(){
        print("adjusting instrument");
    }*/
}
class Wind extends Instrument{

    @Override
    void play(Note n) {
        print("wind.play() "+n);
    }

    @Override
    String what() {
        return "wind";
    }

    @Override
    void adjust() {
        print("adjusting wind");
    }
}

class Stringed extends Instrument{
    @Override
    void play(Note n) {
        print("stringed.play() "+n);
    }

    @Override
    String what() {
        return "stringed";
    }

    @Override
    void adjust() {
        print("adjusting stringed");
    }
}

class Woodwind extends Wind{
    @Override
    void play(Note n) {
        print("woodwind.play() "+n);
    }

    @Override
    String what() {
        return "Woodwind";
    }

    @Override
    void adjust() {
        print("adjusting Woodwind");
    }
}
class Bass extends Wind{
    @Override
    void play(Note n) {
        print("bass.play() "+n);
    }

    @Override
    String what() {
        return "bass";
    }

    @Override
    void adjust() {
        print("adjusting bass");
    }
}

public class Music {
    public static void tune(Instrument i){
        i.play(Note.A);
    }
    public static void tuneAll(Instrument[] e){
        for(Instrument i: e){
            tune(i);
        }
    }
    //多态
    public static void main(String[] args) {
        Instrument[] orchestra={
                new Wind(),new Stringed(),
                new Woodwind(),new Bass()  //upcasting
        };
        tuneAll(orchestra);
    }

}


