package com.nt.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUserOperationsController {

	@GetMapping("/home")
	public String showHome() {
		return "Hello, Welcome to RedBus.com";
	}

	@GetMapping("/after")
	public String afterLogin() {
		return "Hello, Successfully Logged into RedBus.com";
	}

	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal) {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
