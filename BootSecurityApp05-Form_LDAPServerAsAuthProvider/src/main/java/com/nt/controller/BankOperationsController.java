package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}

	@GetMapping("/balance")
	public String checkBalance() {
		return "balance";
	}

	@GetMapping("/loan")
	public String approveLoan() {
		return "loan";
	}

	//handle method to show authorization failure page(403 error)
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
