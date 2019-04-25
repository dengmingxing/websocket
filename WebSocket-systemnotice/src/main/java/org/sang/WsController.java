package org.sang;

import io.swagger.annotations.Api;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by sang on 16-12-22.
 */
@Controller
@Api(tags = "这是用来页面聊天的controller")
public class WsController {
    @MessageMapping("/welcome")//这个就是类似于RequestMapping用来指定路径的
    @SendTo("/topic/getResponse")//该注解是将消息发送给订阅了指定路径的对象
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }
}
