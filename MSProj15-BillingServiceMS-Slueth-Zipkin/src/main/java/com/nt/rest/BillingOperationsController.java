package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger logger = LoggerFactory.getLogger(BillingOperationsController.class);

	@GetMapping("/bill")
	public String Billing() {
		logger.info("Welcome to Billing Module");
		String response = template.getForObject("http://localhost:9093/payment/api/pay", String.class);
		logger.info("Back to Billing Module::" + response);
		return "Bill Amount :Rs 90,000 INR : "+response;
	}

}
