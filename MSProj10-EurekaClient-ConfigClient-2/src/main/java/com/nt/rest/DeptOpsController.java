package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
@RefreshScope
public class DeptOpsController {

	@Value("${dbuser}")
	private String dbuser;

	@Value("${dbpwd}")
	private String dbpwd;

	@GetMapping("/show")
	public ResponseEntity<String> printDBCreds() {
		return new ResponseEntity<String>("Dept--> DB Details:" + dbuser + "/" + dbpwd, HttpStatus.OK);
	}
}
