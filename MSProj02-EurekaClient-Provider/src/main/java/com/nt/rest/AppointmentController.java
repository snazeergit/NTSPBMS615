package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	@GetMapping("/get/appointment")
	public ResponseEntity<String> getAppointment() {
		
		return new ResponseEntity<String>("Appointment has been taken",HttpStatus.OK);
	}
}
