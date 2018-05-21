package com.viscu.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @
 */

@Component
/*@PropertySource("classpath:config/idea.properties") //定位自定义文件的位置*/
@ConfigurationProperties(prefix = "idea",locations = "classpath:config/idea.properties") //1.5locations被弃用
public class IdeaSettings {
    private String author;
    private String word;
    public String getAuthor() {
        return author;
    }
    public String getWord() {
        return word;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setWord(String word) {
        this.word = word;
    }
}
