package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api")
public class CustomerOperationsController {

	/*Here 'sno' is the actual param name but we have created another localname 'no' to  it, 
	when client makes request, they should use the actual param name 'sno' instead of 'no'.*/
	@GetMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam("sno") Integer no, @RequestParam String sname) {
		return new ResponseEntity<String>(no + "  " + sname, HttpStatus.OK);
	}

	/*by default required is true makes it mandatory parameter,if the client
	doesn't pass it then we receive 400 error Bad Request*/
	@GetMapping("/report1")
	public ResponseEntity<String> showReport1(@RequestParam Integer sno, @RequestParam(required = false) String sname) {
		return new ResponseEntity<String>(sno + "  " + sname, HttpStatus.OK);
	}

	/*required = true makes the parameter optional, if you pass the param with 
	matching name and type it will recognize the param if there is any mismatch 
	in name or type then it will be ignored*/
	@GetMapping("/report2")
	public ResponseEntity<String> showReport2(@RequestParam(required = false) Integer sno,
			@RequestParam(required = false) String sname) {
		return new ResponseEntity<String>(sno + "  " + sname, HttpStatus.OK);
	}

	// Postmapping configured for request param are internally passed as part of request body 
	@PostMapping("/report3")
	public ResponseEntity<String> showReport3(@RequestParam(name =  "sno", required = true) Integer no, @RequestParam("sname") String name) {
		return new ResponseEntity<String>(no + "  " + name, HttpStatus.OK);
	}

}
