package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service")
public interface IBillingFiegnClient {
	
	@GetMapping("/billing/api/bill")
	public ResponseEntity<String> billPay();

}
