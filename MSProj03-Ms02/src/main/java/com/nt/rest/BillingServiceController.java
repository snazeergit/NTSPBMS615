package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class BillingServiceController {

	@GetMapping("/getBill")
	public ResponseEntity<String> generateBill() {
		return new ResponseEntity<String>("Final bill amount :: Rs 7740.00/-", HttpStatus.OK);
	}

}
