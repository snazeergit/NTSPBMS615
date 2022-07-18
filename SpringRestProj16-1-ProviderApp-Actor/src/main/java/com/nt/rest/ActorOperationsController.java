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
		String msg = service.registerActor(actor);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Actor>> getAllActors() {
		Iterable<Actor> iterable = service.getAllActors();
		return new ResponseEntity<Iterable<Actor>>(iterable, HttpStatus.OK);
	}

	@GetMapping("/getActor/{id}")
	public ResponseEntity<Actor> getActorById(@PathVariable Integer id) {
		Actor actor = service.getActorById(id);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}

	@GetMapping("/getAll/sort")
	public ResponseEntity<Iterable<Actor>> getAllActorsInSorting() {
		//use any of getAllActorsInSorting1() or getAllActorsInSorting2() or getAllActorsInSorting3()
		Iterable<Actor> iterable = service.getAllActorsInSorting3();
		return new ResponseEntity<Iterable<Actor>>(iterable, HttpStatus.OK);
	}

	@GetMapping("/getActor/{category1}/{category2}")
	public ResponseEntity<List<Actor>> fetchActorsByCategories(@PathVariable String category1, @PathVariable String category2) {
		List<Actor> actorsList = service.fetchActorsByCategories(category1, category2);
		return new ResponseEntity<List<Actor>>(actorsList, HttpStatus.OK);
	}

	@PutMapping("/updateActor")
	public ResponseEntity<String> updateActor(@RequestBody Actor actor) {
		String msg = service.updateActor(actor);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteActor/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable Integer id) {
		String msg = service.deleteActor(id);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/updatemobileNo/{id}/{mobile}")
	public ResponseEntity<String> updateActorMobileNo(@PathVariable Integer id, @PathVariable("mobile") long newMobileNo) {
		String msg = service.updateActorMobileNo(id, newMobileNo);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}

}
