package com.nt.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.ActorInfo;

@Component
public class ObjectMessageReceiver {

	@JmsListener(destination = "obj_mq1")
	public void consumeObjectDataAsMessage(ActorInfo actor) {
		System.out.println("Received object data :: " + actor);
	}

}