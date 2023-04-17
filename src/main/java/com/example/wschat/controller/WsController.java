package com.example.wschat.controller;

import com.example.wschat.model.ActiveUser;
import com.example.wschat.model.ChatMessage;
import com.example.wschat.model.Storage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class WsController {

    @MessageMapping("/chat.logIn")
    @SendTo("/chat/all")
    public ChatMessage logIn(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("userName",chatMessage.getSender());
        Storage.activeUserList.add(new ActiveUser(chatMessage.getSender(),headerAccessor.getSessionId()));
        return chatMessage;
    }
    @MessageMapping("/chat.send")
    @SendTo("/chat/all")
    public ChatMessage send(@Payload ChatMessage chatMessage){
        return chatMessage;
    }
}
