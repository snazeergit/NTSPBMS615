package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmpOpsController {

	@GetMapping("/show")
	public ResponseEntity<String> printDefaultActuators() {
		return new ResponseEntity<String>("Showing Employee Details::-", HttpStatus.OK);
	}
}
