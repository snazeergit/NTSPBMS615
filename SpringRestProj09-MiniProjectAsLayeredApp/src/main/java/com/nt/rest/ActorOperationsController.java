package com.nt.rest;

import java.util.List;

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

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllActors() {
		try {
			Iterable<Actor> iterable = service.getAllActors();
			return new ResponseEntity<Iterable<Actor>>(iterable, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getActorById(@PathVariable Integer id) {
		try {
			Actor actor = service.getActorById(id);
			return new ResponseEntity<Actor>(actor, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll/sort")
	public ResponseEntity<?> getAllActorsInSorting() {
		try {
			//use any of getAllActorsInSorting1() or getAllActorsInSorting2() or getAllActorsInSorting3()
			Iterable<Actor> iterable = service.getAllActorsInSorting3();
			return new ResponseEntity<Iterable<Actor>>(iterable, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getActor/{category1}/{category2}")
	public ResponseEntity<?> fetchActorsByCategories(@PathVariable String category1, @PathVariable String category2) {
		try {
			List<Actor> actorsList = service.fetchActorsByCategories(category1, category2);
			return new ResponseEntity<List<Actor>>(actorsList, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateActor")
	public ResponseEntity<?> updateActor(@RequestBody Actor actor) {

		try {
			String msg = service.updateActor(actor);
			return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteActor/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable Integer id) {

		try {
			String msg = service.deleteActor(id);
			return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/updatemobileNo/{id}/{mobile}")
	public ResponseEntity<?> updateActorMobileNo(@PathVariable Integer id, @PathVariable("mobile") long newMobileNo) {

		try {
			String msg = service.updateActorMobileNo(id, newMobileNo);
			return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
