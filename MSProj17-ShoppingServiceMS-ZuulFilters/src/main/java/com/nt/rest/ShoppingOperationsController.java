package com.nt.rest;

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
	
	@GetMapping("/shop")
	public String Shopping() {
		//Communicate with another MS (Billing Service)
		String response = template.getForObject("http://localhost:9092/billing/api/bill", String.class);
		return "Shopping operation : "+response;
	}
}
