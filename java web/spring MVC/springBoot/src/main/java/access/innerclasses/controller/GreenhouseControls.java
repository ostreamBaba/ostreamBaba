package access.innerclasses.controller;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */
public class GreenhouseControls extends Controller{
    private boolean light=false;
    public class LightOn extends Event{
        public LightOn(long delayTime) {
            super( delayTime );
        }
        @Override
        public void action() {
            light=true;
        }
        @Override
        public String toString() {
            return "light is on";
        }
    }
    public class LightOff extends Event{
        public LightOff(long delayTime) {
            super( delayTime );
        }
        @Override
        public void action() {
            light=false;
        }
        @Override
        public String toString() {
            return "light is false";
        }
    }

    private boolean water=false;
    public class WaterOn extends Event{
        public WaterOn(long delayTime) {
            super( delayTime );
        }
        @Override
        public void action() {
            water=true;
        }
        @Override
        public String toString() {
            return "water is on";
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime) {
            super( delayTime );
        }
        @Override
        public void action() {
            water=false;
        }
        @Override
        public String toString() {
            return "water is false";
        }
    }

    public class Restart extends Event{
        private Event[] events;
        public Restart(long delayTime,Event[] events) {
            super( delayTime );
            this.events=events;
            for(Event e:events){
                addEvent(e);
            }
        }
        @Override
        public void action() {
            for(Event e:events){ //把之前的动作加进去
                e.start();
                addEvent(e);
            }
            start();  //把重启这个动作加进去 即可方式执行这个过程
            addEvent(this); //加入这个对象 过段时间可以重新开始
        }
        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event{
        public Terminate(long delayTime) {
            super( delayTime );
        }
        @Override
        public void action() {
            System.exit(0);
        }
        @Override
        public String toString() {
            return "Terminating";
        }
    }

}
