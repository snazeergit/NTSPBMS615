package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Tourist;

@RestController
@RequestMapping("/wish/api")
public class WishMessageGenerator {

	@GetMapping("/message/{id}/{name}")
	public ResponseEntity<String> showWishMessage(@PathVariable Integer id, @PathVariable String name) {
		System.out.println(id + "               " + name);
		return new ResponseEntity<String>("GoodNight" + id + "     " + name, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Tourist> registerTourist(@RequestBody Tourist tourist) {
		System.out.println("WishMessageGenerator.registerTourist()");
		return new ResponseEntity<Tourist>(tourist, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable Integer id) {
		System.out.println("WishMessageGenerator.deleteTourist()");
		return new ResponseEntity<String>(id+" tourist is deleted", HttpStatus.OK);
	}

}