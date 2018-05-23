package com.ostreambaba.websocket.weChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @ Create by ostreamBaba on 18-5-22
 * @ 点对点控制器
 */
@Controller
public class wsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; //向浏览器发送消息

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){ //Spring MVC中可以直接获得principal(包含当前用户的信息)
        if(principal.getName().endsWith("admin")){
            simpMessagingTemplate.convertAndSendToUser("user","/queue/notifications"
            ,principal.getName()+"-send: "+msg);
        }else{
            simpMessagingTemplate.convertAndSendToUser("admin","/queue/notifications",
                    principal.getName()+"-send: "+msg); //第一个是接受消息的用户 第二个是订阅地址 第三个是消息本身
        }
    }

}
