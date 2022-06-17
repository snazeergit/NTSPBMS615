package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.jsf.FacesContextUtils;

@RestController
@RequestMapping("/emp/api")
public class EmployeeOperationsManager {

	// executes only if the URL
	// ......../show/<any integer>/<anything>
	@GetMapping("/show/{eno}/{ename}") // eno and ename are the dynamic path variables
	public ResponseEntity<String> showEmployeeDetails(@PathVariable(name = "eno", required = false) Integer no,
			@PathVariable(required = false) String ename) {
		System.out.println("EmployeeOperationsManager.showEmployeeDetails()");
		return new ResponseEntity<String>("method with path : /show/{eno}/{ename}", HttpStatus.OK);
	}

	// executes only if the URL
	// ......../show/eno/<anything>
	@GetMapping("/show/eno/{ename}") // eno is static path variable and ename is dynamic path variable
	public ResponseEntity<String> showEmployeeDetails1(@PathVariable(name = "eno", required = false) Integer no,
			@PathVariable String ename) {
		System.out.println("EmployeeOperationsManager.showEmployeeDetails1()");
		return new ResponseEntity<String>("method with path : /show/eno/{ename}", HttpStatus.OK);
	}

	// executes only if the URL
	// ......../show/<any number>/ename
	@GetMapping("/show/{eno}/ename") // eno is dynamic path variable and ename is static path variable
	public ResponseEntity<String> showEmployeeDetails2(@PathVariable(name = "eno", required = false) Integer no,
			@PathVariable(required = false) String ename) {
		System.out.println("EmployeeOperationsManager.showEmployeeDetails2()");
		return new ResponseEntity<String>("method with path : /show/{eno}/ename", HttpStatus.OK);
	}

	// executes only if the URL
	// ......../show/eno/ename
	@GetMapping("/show/eno/ename") // eno and ename are static path variables
	public ResponseEntity<String> showEmployeeDetails3(@PathVariable(name = "eno", required = false) Integer no,
			@PathVariable(required = false) String ename) {
		System.out.println("EmployeeOperationsManager.showEmployeeDetails3()");
		return new ResponseEntity<String>("method with path : /show/eno/ename", HttpStatus.OK);
	}

}
