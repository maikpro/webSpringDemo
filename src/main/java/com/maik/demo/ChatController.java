package com.maik.demo;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.maik.demo.entity.ChatNachricht;

/*
 * Quellen: 
 * https://www.baeldung.com/spring-websockets-send-message-to-user
 * https://medium.com/javarevisited/building-persistable-one-to-one-chat-application-using-spring-boot-and-websockets-303ba5d30bb0
 * */

@Controller
public class ChatController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate; //nutzt Methoden um eine Nachricht an User zu schicken!
	
	
	 //Die Nachricht wird nun an /app/chat gesendet!
	/* @param nachricht ist vom Typ ChatNachricht und enthält die Nachricht zum Senden
	 * @param user ist vom Typ Principal repräsentiert eine Entity (mit der User-ID)
	 * */
	@MessageMapping("/chat")
	public void nachrichtSenden(@Payload ChatNachricht nachricht, Principal user, @Header("simpSessionId") String sessionId) throws Exception {
		System.out.println("SessionID: " + sessionId);
		System.out.println("User: " + user);
		System.out.println("Nachricht: " + nachricht.getInhalt());
		
		//simpMessagingTemplate.convertAndSendToUser(user.getName(), "/user/" + sessionId +"/queue/messages", nachricht.getInhalt());
		simpMessagingTemplate.convertAndSend("/user/" + sessionId + "/queue/messages", nachricht.getInhalt() + new Date());
		//Die Nachricht wird an den User maik an die URL /queue/messages geschickt!
		
	}
}
