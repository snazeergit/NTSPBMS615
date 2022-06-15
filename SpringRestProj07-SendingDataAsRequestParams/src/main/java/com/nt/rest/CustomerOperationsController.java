package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api")
public class CustomerOperationsController {

	@GetMapping("/report")//'sno' is the actual param name but we have created another localname 'no' to it, when client makes request it should use the actual param name 'sno' instead of 'no'.
	public ResponseEntity<String> showReport(@RequestParam("sno") Integer no, @RequestParam String sname) {
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.OK);
	}

	@GetMapping("/report1")//by default required is true makes it mandatory parameter,if the client doesn't pass it then we receive 400 error Bad Request
	public ResponseEntity<String> showReport1(@RequestParam Integer sno, @RequestParam (required = false)String sname) {
		return new ResponseEntity<String>(sno + "  " + sname, HttpStatus.OK);
	}
	
	@GetMapping("/report2")//required = true makes the parameter optional, if you pass the param with matching name and type it will recognize the param if there is any mismatch in name or type then it will be ignored 
	public ResponseEntity<String> showReport2(@RequestParam (required = false)Integer sno, @RequestParam (required = false)String sname) {
		return new ResponseEntity<String>(sno + "  " + sname, HttpStatus.OK);
	}
	
}
