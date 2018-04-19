package access.innerclasses.controller;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc=new GreenhouseControls();
        Event[] events={
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800)
        };
        gc.addEvent(gc.new Restart(1400,events));
        /*if(args.length==1){
            gc.addEvent(
                    new GreenhouseControls.Terminate(new Integer(args[0]))
            );
        }*/
        gc.run();
    }
}