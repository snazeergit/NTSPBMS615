package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/api")
public class PaymentOperationsController {

	@GetMapping("/pay")
	public String payment() {
		return "Payment is done using PhonePe UPI";
	}
}
