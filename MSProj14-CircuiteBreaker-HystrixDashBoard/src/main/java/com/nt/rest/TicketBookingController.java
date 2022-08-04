package com.nt.rest;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("booking/api")
public class TicketBookingController {

	@GetMapping("/book")
	
	/*@HystrixCommand(fallbackMethod = "dummyBookTickets", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true")})*/
	
	@HystrixCommand(fallbackMethod = "dummyBookTickets", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000") })
	public String bookTickets() {
		System.out.println("business method");
		if (new Random().nextInt(10) > 3)
			throw new IllegalArgumentException("Problem in ticket booking");
		return "Tickets booked";
	}

	//fallback method
	int count = 0;

	public String dummyBookTickets() {
		count++;
		System.out.println("fallback method  ::" + LocalDateTime.now() + "--" + count);
		System.out.println("------------------------");
		return "Sorry for this inconvenience caused.......Please try after sometime!";
	}

}
