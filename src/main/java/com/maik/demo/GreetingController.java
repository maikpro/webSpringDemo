package com.maik.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.maik.demo.entity.Greeting;
import com.maik.demo.entity.HelloMessage;

//Quelle: https://spring.io/guides/gs/messaging-stomp-websocket/

@Controller
public class GreetingController {
	/*
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000);
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}*/
}
