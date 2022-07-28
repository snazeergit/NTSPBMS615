package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptOpsController {

	@Value("${dbuser}")
	private String uname;

	@Value("${dbpwd}")
	private String pwd;

	@GetMapping("/show")
	public ResponseEntity<String> printDbDetails() {
		return new ResponseEntity<String>("Dept===> DB details::" + uname + "/" + pwd, HttpStatus.OK);
	}
}
