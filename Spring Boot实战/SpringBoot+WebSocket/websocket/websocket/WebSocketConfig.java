package com.viscu.springboot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @ Create by ostreamBaba on 18-5-22
 * @ 需要添加websocket的依赖
 */

//广播式  即服务端有消息 会将消息发送给所有链接了当前endpoint的浏览器


@Configuration
@EnableWebSocketMessageBroker    //开启webSocket支持 开启使用STOMP协议来传输基于代理(message broker)的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { //注册STOMP协议的节点 并映射指定的url
        registry.addEndpoint("/endpoint").withSockJS(); //注册一个STOMP的endpoint 并指定使用SockJS协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //配置一个消息代理
        registry.enableSimpleBroker("/topic");//广播式应配置一个/topic消息代理
    }
}
