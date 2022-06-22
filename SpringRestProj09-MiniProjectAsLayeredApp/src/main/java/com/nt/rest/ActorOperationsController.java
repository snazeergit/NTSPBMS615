package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.service.IActorMgmtService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationsController {

	@Autowired
	private IActorMgmtService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveActor(@RequestBody Actor actor) {
		try {
			String msg = service.registerActor(actor);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
