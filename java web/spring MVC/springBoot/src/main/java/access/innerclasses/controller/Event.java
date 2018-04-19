package access.innerclasses.controller;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) { //延迟时间
        this.delayTime = delayTime;
    }
    public void start(){
        eventTime=System.nanoTime()+delayTime;
    }
    public boolean ready(){
        return System.nanoTime()>=eventTime;
    }
    public abstract void action();
}
