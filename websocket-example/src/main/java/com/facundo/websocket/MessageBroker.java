package com.facundo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * @author facundo.ferro
 */
@Controller
public class MessageBroker  {

    @Autowired
    SimpMessageSendingOperations messagingTemplate;

    public void notifyArrival(String message) {
        String channelPath = "/topic/WebSocketExample/message";
        messagingTemplate.convertAndSend(channelPath, message);
    }
    
    @SubscribeMapping("/message")
    public void getMessageFromSocket(String message) {
    	notifyArrival(message);
    }
}
