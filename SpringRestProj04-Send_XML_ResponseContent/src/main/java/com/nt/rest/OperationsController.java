package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/operations/api")
public class OperationsController {

	@GetMapping("/company")
	public ResponseEntity<Company> showCompanyDetails() {
		Company company = new Company("HCL", "Hyd", 100, 50000000000.0, "IT");
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

	@GetMapping("/employee")
	public ResponseEntity<Employee> showEmployeeDetails() {
		Company company = new Company("VMware", "Hyd", 100, 50000000000.0, "IT");
		Employee emp = new Employee("Nazeer", new String[] { "cricket", "Movies" },
				List.of("Ooty", "Wayanad", "Kanyakumari"), Set.of("Telugu", "Hindi", "English", "Urdu"),
				Map.of("Java", 8.0f, "SpringBoot", 2.7f), false, company);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
