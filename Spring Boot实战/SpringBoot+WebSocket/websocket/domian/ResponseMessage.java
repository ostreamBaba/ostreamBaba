package com.viscu.springboot.domian;

/**
 * @ Create by ostreamBaba on 18-5-22
 * @ 服务端向浏览器发送的此类的消息
 */
public class ResponseMessage {
    private String responseMessage;
    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}
