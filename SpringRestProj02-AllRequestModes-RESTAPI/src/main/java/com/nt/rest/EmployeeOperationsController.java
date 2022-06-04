package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {

	@GetMapping("/all")
	public ResponseEntity<String> listAllEmpoyee() {
		System.out.println("EmployeeOperationsController.listAllEmpoyee()");
		return new ResponseEntity<String>("@GetMapping-Fetching all employees", HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveEmpoyee() {
		System.out.println("EmployeeOperationsController.saveEmpoyee()");
		return new ResponseEntity<String>("@PutMapping-Saving the employee", HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmpoyee() {
		System.out.println("EmployeeOperationsController.updateEmpoyee()");
		return new ResponseEntity<String>("@PutMapping-Updating the employee", HttpStatus.ACCEPTED);
	}

	@PatchMapping("/updateEmail")
	public ResponseEntity<String> updateEmpoyeeEmail() {
		System.out.println("EmployeeOperationsController.updateEmpoyeeEmail()");
		return new ResponseEntity<String>("@PatchMapping-update employee email", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmpoyee() {
		System.out.println("EmployeeOperationsController.deleteEmpoyee()");
		return new ResponseEntity<String>("@GetMapping-deleting employees", HttpStatus.OK);
	}
}
