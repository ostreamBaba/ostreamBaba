package com.springboot.security.domain;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */
public class Msg {
    private String title;
    private String content;
    private String extraInfo;

    public Msg(String title, String content, String etraInfo) {
        this.title = title;
        this.content = content;
        this.extraInfo = etraInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
