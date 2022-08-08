package com.nt.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/api")
public class PaymentOperationsController {

	Logger logger = LoggerFactory.getLogger(PaymentOperationsController.class);

	@GetMapping("/pay")
	public String payment() {
		logger.info("Welcome to Payment Module");
		logger.info("Payment Operation is completed");
		return "Payment is done using PhonePe UPI";
	}
}
