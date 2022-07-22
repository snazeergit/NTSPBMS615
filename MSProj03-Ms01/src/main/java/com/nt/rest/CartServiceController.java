package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.ConsumerClient;

@RestController
@RequestMapping("/cart/api")
public class CartServiceController {

	@Autowired
	private ConsumerClient client;

	@GetMapping("/viewCart")
	public ResponseEntity<String> showCart() {
		String billingInfo = client.billingInfo();
		return new ResponseEntity<String>("Provisions added to the cart :: "+billingInfo, HttpStatus.OK);
	}
}
