package com.design.adapter.chapter2;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ 对象适配器--交给其他人
 */
public class PrintBanner extends Print{
    private Banner banner;//委托关系 当PrintBanner类的printWeak被调用的时候，并不是PrintBanner类自己处理,
    //而是将处理交给其他实例(Banner实例)的showWithParen()方法处理
    public PrintBanner(String string) {
        banner=new Banner(string);
    }
    @Override
    public void printWeak() {
        banner.showWithParen();
    }
    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
