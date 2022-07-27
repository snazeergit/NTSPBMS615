package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billing/api")
public class BillingRestController {

	@GetMapping("/bill")
	public ResponseEntity<String> getBill() {
		return new ResponseEntity<String>("Total Bill: 12,500/-", HttpStatus.OK);
	}
}
