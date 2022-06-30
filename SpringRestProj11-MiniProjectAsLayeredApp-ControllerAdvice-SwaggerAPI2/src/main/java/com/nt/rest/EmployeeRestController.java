package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/emp/api/")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	

	@ApiOperation("Employee registration")
	@PostMapping("/post/{token}")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee, @PathVariable Object token) {
		String message = service.addEmployee(employee);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@ApiOperation("Fetch employee details by eno")
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Employee employee = service.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@ApiOperation("Fetch all employees") // It display this name instead of method name in Swagger
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
		Iterable<Employee> employee = service.getAllEmployees();
		return new ResponseEntity<Iterable<Employee>>(employee, HttpStatus.OK);
	}

	@ApiOperation("Update employee details")
	@PutMapping("/put")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		String message = service.updateEmployee(employee);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@ApiOperation("Update employee location")
	@PatchMapping("/patch")
	public ResponseEntity<String> updateEmpLocation(@RequestBody Employee employee) {
		Integer id = employee.getEmpNo();
		String location = employee.getEmpLocation();
		String message = service.updateEmpLocation(id, location);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@ApiOperation("Remove employee")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> terminateEmployee(@PathVariable Integer id) {
		String message = service.terminateEmployee(id);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}
}
