package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class BillingController {
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/printBill")
	public ResponseEntity<String> printBill(){
		return new ResponseEntity<String>("Total bill amount : 24,500/- using "+port, HttpStatus.OK);
	}

}
