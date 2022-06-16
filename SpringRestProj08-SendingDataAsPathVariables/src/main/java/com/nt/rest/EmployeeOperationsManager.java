package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/api")
public class EmployeeOperationsManager {
	
	@GetMapping("/show/{eno}/{ename}")//eno and ename are the path variables 
	public ResponseEntity<String> showEmployeeDetails(@PathVariable("eno") Integer no, @PathVariable String ename) {
		System.out.println(no + "<-------->" + ename);
		return new ResponseEntity<String>(no + "<---->" + ename, HttpStatus.OK);
	}

}
