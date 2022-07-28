package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmpOpsController {

	//These(dbuser, dbpwd) are the keys specified in the external Configuration Server(in GITLab application.properties )
	@Value("${dbuser}")
	private String dbUsername;

	@Value("${dbpwd}")
	private String dbPassword;

	@GetMapping("/show")
	public ResponseEntity<String> showDbDetails() {
		return new ResponseEntity<String>("Emp--->DB details :: " + dbUsername + " / " + dbPassword, HttpStatus.OK);
	}
}
