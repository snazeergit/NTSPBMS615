package com.nt.runner;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class PTPMessageSenderRunner implements CommandLineRunner {

	@Autowired
	private JmsTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		//Normal Anonymous inner class for MessageCreator Interface
		/*	template.send("queue1", new MessageCreator() {
		
				@Override
				public Message createMessage(Session session) throws JMSException {
					Message message = session.createTextMessage("from Sender " + new Date());
					return message;
				}
			});*/
		
		//LMBDA based Anonymous inner class for MessageCreator interface
		/*template.send("queue1",session->{
			Message message=session.createTextMessage("from Sender:: "+new Date());
			return message;
		});*/
		
		//LMBDA based Anonymous inner class for MessageCreator interface
		template.send("queue1",session->	session.createTextMessage("from Sender:: "+new Date()));
		
		System.out.println("From Sender:: The message is sent");
	}

}
