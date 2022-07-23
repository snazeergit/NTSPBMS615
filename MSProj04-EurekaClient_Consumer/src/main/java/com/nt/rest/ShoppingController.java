package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.LoadBalancerClientApp;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingController {

	@Autowired
	private LoadBalancerClientApp lbClient;

	@GetMapping("/doShoppping")
	public ResponseEntity<String> doShopping() {
		String providerResponse = lbClient.getProviderInstance();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Provisions added to the cart :: " + providerResponse, HttpStatus.OK);
	}

}
