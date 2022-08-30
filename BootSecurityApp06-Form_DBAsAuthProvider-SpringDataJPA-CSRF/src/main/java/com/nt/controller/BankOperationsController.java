package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}

	@PostMapping("/balance")
	public String checkBalance(Map<String,Object> map) {
		map.put("balance", new Random().nextInt(1000000));
		return "balance";
	}

	@GetMapping("/loan")
	public String approveLoan(Map<String,Object> map) {
		map.put("loan", new Random().nextInt(1000000));
		return "loan";
	}

	//handle method to show authorization failure page(403 error)
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
