package org.sang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by sang on 16-12-22.
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 该方法需要获取用户和信息两个参数
     * 还需要simpMessagingTemplate对象的方法convertAndSendToUser来指定发送给谁的
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("sang")) {
            messagingTemplate.convertAndSendToUser("lenve", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("sang", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }
    }
}
