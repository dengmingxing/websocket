package org.sang;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by sang on 16-12-22.
 */
@Configuration
@EnableWebSocketMessageBroker//这是表示使用stomp协议来处理代理的消息
@Api(tags = "这是配置webSocketConfig的配置类")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 实现的第一个方法是registerStompEndpoints,该方法是用来知道那个url地址和指定协议
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();
    }
    /**
     * 实现的第二个方法是configureMessageBroker是用来指定信息的发送方式；是点对点的通信还是系统通知
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/topic");
    }
}
