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

	@Value("${dbuser}")
	private String dbUname;

	@Value("${dbpwd}")
	private String dbPwd;

	@GetMapping("/show")
	public ResponseEntity<String> printDbCredentials(){
		return new ResponseEntity<String>("Emp==> DB details::"+dbUname+"/"+dbPwd, HttpStatus.OK
				);
	}
	
}
