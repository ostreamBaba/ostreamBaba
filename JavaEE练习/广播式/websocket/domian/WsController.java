package com.viscu.springboot.domian;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @ Create by ostreamBaba on 18-5-22
 * @ 描述
 */

@Controller
public class WsController {
    @MessageMapping("/welcome") //当浏览器向服务端发送请求时 通过@ResquestMapping映射到/welcome这个地址
    @SendTo("/topic/getResponse") //当服务端有消息的时候 会对订阅了@SendTo中的路径的浏览器发送消息
    public ResponseMessage say(ResquestMessage resquestMessage){
        System.out.println(resquestMessage.getName());
        return new ResponseMessage("welcome, "+ resquestMessage.getName()+"!");
    }
}
