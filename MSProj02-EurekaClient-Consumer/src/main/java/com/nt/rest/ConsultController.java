package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.DiscoveryClient1;

@RestController
@RequestMapping("/api")
public class ConsultController {
	
	@Autowired
	private DiscoveryClient1 client;

	@GetMapping("/get/consult")
	public ResponseEntity<String> getConsultation() {
		String providerResponse = client.getProviderInstance();
		return new ResponseEntity<String>("Consultation is in progress... "+providerResponse,HttpStatus.OK);
	}
}
