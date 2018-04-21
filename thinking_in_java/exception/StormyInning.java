package com.ostream.ThinkingInJavaII.exceptions;

/**
 * @Create by ostreamBaba on 18-4-21
 * @描述
 */

//异常的限制

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
    //声明可能抛出异常 实际上并没有抛出
    public Inning() throws BaseballException{  //强制用户去捕获可能在覆盖后的event版本中增加的异常
        //throw new BaseballException();
    }
    public void event()throws BaseballException{

    }
    public void eventPlus()throws BaseballException{
        throw new BaseballException();
    }
    public abstract void atBat()throws Foul,Strike;
    public void walk(){}
}
class StormException extends Exception{}
class RaineOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
    void event()throws RaineOut; //抛出新的异常
    void eventPlus()throws BaseballException;
    void rainHand()throws RaineOut;
}

//派生类构造器不能捕获基类构造器抛出的异常
public class StormyInning extends Inning implements Storm{
    //构造器可以抛出任何异常 但必须包含基类构造器的异常说明
    public StormyInning() throws BaseballException, RaineOut{
        //throw new BaseballException();
    }
    public StormyInning(String s) throws BaseballException, Foul{
    }
    /*@Override
    public void walk() throws Exception{
        super.walk();
    }*/
    //强制派生类遵守基类的异常说明
    @Override
    public void rainHand() throws RaineOut {

    }
    //在继承与覆盖的过程中 某个特定方法的"异常说明的接口"不是变大了而是变小了
    @Override
    public void walk() {
        super.walk();
    }
    //PopFoul异常是Foul派生出来的 异常处理程序也能捕获到PopFoul异常
    @Override
    public void atBat() throws PopFoul{
        /*System.out.println("caught PopFoul Exception");
        throw new PopFoul();*/
    }
    //由于Storm定义了event方法 抛出了新的异常
    //如果在StormInning类即实现Inning中的event又实现storm中的event 那么storm的event既不能改变在Inning中event方法中的异常接口
    @Override
    public void event(){

    }
    @Override
    public void eventPlus() throws BaseballException {
        //super.eventPlus();
    }

    public static void main(String[] args) {

        //强制捕捉StormyInning类抛出的异常
        try{
            StormyInning si=new StormyInning();
            si.atBat();
            si.eventPlus();
        }catch (PopFoul e){
            System.out.println("Pop Foul");
        }catch (BaseballException e){
            System.out.println("Generic baseball exception");
        }catch (RaineOut e){
            System.out.println("Rained out");
        }
        //Strike not thrown in derived version

        //upcasting
        //向上转型基类型 要求捕获基类的异常类型
        try{
            Inning in=new StormyInning();
            in.atBat();
        }catch (Strike e){
            System.out.println("Strike");
        }catch (Foul e){
            System.out.println("Foul");
        }catch (RaineOut e){
            System.out.println("RaineOut");
        } catch (BaseballException e){
            System.out.println("Generic baseball exception");
        }
    }

    //eg: StormInning的方法抛出异常
    //第一个try块捕捉到PopFoul异常
    //第二个try块 由于PopFoul是继承Foul异常 所以会捕获到Foul异常

}
