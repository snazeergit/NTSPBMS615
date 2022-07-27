package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingFiegnClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingRestController {

	@Autowired
	private IBillingFiegnClient client;
	
	@GetMapping("/shop")
	public ResponseEntity<String> addCart() {
		ResponseEntity<String> responseEntity = client.billPay();
		String providerResponse = responseEntity.getBody();
		return new ResponseEntity<String>("Goods added to the cart:: "+providerResponse, HttpStatus.OK);
	}
}
