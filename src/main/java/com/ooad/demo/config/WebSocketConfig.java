package com.ooad.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//TUTORIAL: https://medium.com/javarevisited/building-persistable-one-to-one-chat-application-using-spring-boot-and-websockets-303ba5d30bb0

/** WebSocketConfig
 * @author Maik Proba (Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	/**
	 * @param registry hierbei wird der MessageBroker für die nachrichtenbasierte Kommunikation beim Chat konfiguriert. Das Ziel der Anwendung ist /app und die Nachricht wird an /app/chat/messages geschickt.
	 *
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/chat", "/messages");
		registry.setApplicationDestinationPrefixes("/app"); //Ziel URL: /app/...
		registry.setUserDestinationPrefix("/user");
	}
	
	/**
	 * @param registry hierbei wird der Endpunkt festgelegt auf den das STOMP zugreift. Im Javascript websocket.js wird in der Methode connect() der WebSocket mit dem STOMP erzeugt.
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry
				.addEndpoint("/ws") //In JavaScript wird dies als Endpunkt zum Verbinden des SockJs-Objekts verwendet!
				.withSockJS(); //Für SockJS!
	}
}
