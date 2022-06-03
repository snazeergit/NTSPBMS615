package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi") // global path
public class MessageRenderController {

	@GetMapping("/wish") // method path or operation path
	public ResponseEntity<String> showMessage() {
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		String msg = null;
		if (hour < 12) {
			msg = "Good Morning!";
		} else if (hour < 16) {
			msg = "Good Afternoon!";
		} else if (hour < 21) {
			msg = "Good Evenig!";
		} else
			msg = "Good Night!";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return responseEntity;
	}
}
