package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingOperationsController {

	@Autowired
	private RestTemplate template;
	Logger logger = LoggerFactory.getLogger(ShoppingOperationsController.class);
	
	@GetMapping("/shop")
	public String Shopping() {
		logger.info("Welcome to shopping module");
		//Communicate with another MS (Billing Service)
		String response = template.getForObject("http://localhost:9092/billing/api/bill", String.class);
		logger.info("Billing is invoked");
		logger.info("Back to shopping module:: "+response);
		return "Shopping operation : "+response;
	}
}
