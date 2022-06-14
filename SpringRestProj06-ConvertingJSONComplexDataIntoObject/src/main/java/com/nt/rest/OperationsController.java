package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;

@RestController
@RequestMapping("company/api")
public class OperationsController {

	@PostMapping("/register")
	public ResponseEntity<Company> registerCompany(@RequestBody Company company){
		return new ResponseEntity<Company>(company, HttpStatus.CREATED);
	}
}
