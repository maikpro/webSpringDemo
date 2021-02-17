package com.ooad.demo.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.ooad.demo.entity.ChatNachricht;

/*
 * Quellen: 
 * https://www.baeldung.com/spring-websockets-send-message-to-user
 * https://medium.com/javarevisited/building-persistable-one-to-one-chat-application-using-spring-boot-and-websockets-303ba5d30bb0
 * */

/** ChatController
 * @author Maik Proba(Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

@Controller
public class ChatController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate; //nutzt Methoden um eine Nachricht an User zu schicken!
	
	/** nachrichtSenden wird aufgerufen nachdem der Client einen Nachricht gesendet hat.
	 * @param nachricht enthaelt den Inhalt der Nachricht vom Client zum Senden. Die Nachricht hat der Client vorher im Input-Field in (/chat) eingegeben.
	 * @param user repraesentiert den User von dem die Nachricht geschrieben wurde.
	 **/
	@MessageMapping("/chat")
	public void nachrichtSenden(@Payload ChatNachricht nachricht, Principal user){
		if( user.getName().equals("admin") ) {
			//Nachricht an Seller
			simpMessagingTemplate.convertAndSendToUser("seller", "/chat/messages", user.getName() + ": " + nachricht.getInhalt() + nachricht.getZeitstempel());
		} else {
			//an den Admin Nachricht
			simpMessagingTemplate.convertAndSendToUser("admin", "/chat/messages", user.getName() + ": " + nachricht.getInhalt() + nachricht.getZeitstempel());
		}
	}
}
