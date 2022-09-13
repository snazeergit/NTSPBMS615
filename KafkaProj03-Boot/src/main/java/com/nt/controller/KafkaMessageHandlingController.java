package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.MessageStore;
import com.nt.producer.MessageProducer;

@RestController
public class KafkaMessageHandlingController {

	@Autowired
	private MessageProducer producer;

	@Autowired
	private MessageStore msgStore;

	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		String status = producer.sendMessage(message);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<String>> fetchAllMessage() {
		List<String> allMessages = msgStore.getAllMessages();
		return new ResponseEntity<List<String>>(allMessages, HttpStatus.OK);
	}
}
