package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@RestController
@RequestMapping("/emp/api/")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;

	@PostMapping("/post")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee) {
		String message = service.addEmployee(employee);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Employee employee = service.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping("/put")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		String message = service.updateEmployee(employee);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/patch/{id}/{location}")
	public ResponseEntity<String> updateEmpLocation(@PathVariable Integer id, @PathVariable String location) {
		String message = service.updateEmpLocation(id, location);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> terminateEmployee(@PathVariable Integer id) {
		String message = service.terminateEmployee(id);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
}
