package com.design.adapter.chapter1;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ °çÑİÊÊÅäÆ÷½ÇÉ«
 */
public class PrintBanner extends Banner implements Print{
    public PrintBanner(String string) {
        super( string );
    }
    @Override
    public void PrintWeak() {
        showWithParen();
    }
    @Override
    public void PrintStrong() {
        showWithAster();
    }
}
