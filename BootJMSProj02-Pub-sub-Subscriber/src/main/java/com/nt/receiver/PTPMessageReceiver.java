package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PTPMessageReceiver {

	@JmsListener(destination = "topic1 ")
	public void readMessage(String text) {
		System.out.println("Received message:: " + text);
	}

}
