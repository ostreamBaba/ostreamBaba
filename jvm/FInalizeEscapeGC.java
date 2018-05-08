package com.ostream.JVM;

/**
 * @ Create by ostreamBaba on 18-5-8
 * @ 描述
 * 1.对象可以在被GC时自救
 * 2.这种自救机会只有一次 因为一个对象的finalize()方法最多只能执行一次
 */
public class FInalizeEscapeGC {
    private static FInalizeEscapeGC SAVE_HOOK=null;
    private void isAlive(){
        System.out.println("yes,i'am still alive :)");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FInalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK=new FInalizeEscapeGC();
        //对象第一次成功自救
        SAVE_HOOK=null;
        System.gc();
        //finalize()方法的优先级很低 所以暂停0.5秒等待它
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i'am dead :(");
        }

        //自救失败
        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,i'am dead :(");
        }
    }
}
