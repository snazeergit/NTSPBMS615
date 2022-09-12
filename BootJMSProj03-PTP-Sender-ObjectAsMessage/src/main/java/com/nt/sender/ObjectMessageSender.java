package com.nt.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.ActorInfo;

@Component
public class ObjectMessageSender {

	@Autowired
	private JmsTemplate template;

	@Scheduled(cron = "0/20 * * * * * ")
	public void sendObjectDataAsMessage() {
		//Prepare Object
		ActorInfo actor = new ActorInfo(1001, "ranveer", "Mumbai");

		//Send object as the message
		template.convertAndSend("obj_mq1", actor);

		System.out.println("From Sender:: The message is sent");
	}

}
