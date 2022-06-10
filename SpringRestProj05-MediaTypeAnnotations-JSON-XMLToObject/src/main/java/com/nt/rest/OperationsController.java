package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/operations/api")
public class OperationsController {

	@PostMapping("/company")
	public ResponseEntity<Company> showCompanyDetails(@RequestBody Company company) {
		System.out.println("OperationsController.showCompanyDetails()");
		return new ResponseEntity<Company>(company, HttpStatus.CREATED);
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> showEmployeeDetails(@RequestBody Employee emp) {
		System.out.println("OperationsController.showEmployeeDetails()");
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
}
