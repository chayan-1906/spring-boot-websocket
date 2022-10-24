package com.padmanabhasmac.spring.websocket.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.padmanabhasmac.spring.websocket.api.model.ChatMessageModel;

@Controller
public class ChatController {

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessageModel register(
			@Payload ChatMessageModel chatMessageModel,
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessageModel.getSender());
		return chatMessageModel;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessageModel sendMessage(@Payload ChatMessageModel chatMessageModel) {
		return chatMessageModel;
	}
	
	
}
