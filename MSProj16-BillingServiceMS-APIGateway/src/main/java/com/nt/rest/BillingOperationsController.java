package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/billing/api")
public class BillingOperationsController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/bill")
	public String Billing() {
		String response = template.getForObject("http://localhost:9093/payment/api/pay", String.class);
		return "Bill Amount :Rs 90,000 INR : " + response;
	}

}
