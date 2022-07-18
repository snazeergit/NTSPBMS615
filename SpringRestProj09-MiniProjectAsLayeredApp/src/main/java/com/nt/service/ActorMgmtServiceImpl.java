package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.ActorNotFoundException;
import com.nt.model.Actor;
import com.nt.repository.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepo actorRepo;

	@Override
	public String registerActor(Actor actor) {
		Actor actor2 = actorRepo.save(actor);
		return "Actor is registered with ID value : " + actor2.getActorId();
	}

	@Override
	public Iterable<Actor> getAllActors() {
		Iterable<Actor> iterable = actorRepo.findAll();
		return iterable;
	}

	@Override
	public Actor getActorById(Integer id) {
		Actor actor = actorRepo.findById(id).get();
		return actor;
	}

	@Override //Sorting using list
	public Iterable<Actor> getAllActorsInSorting1() {
		Iterable<Actor> iterable = actorRepo.findAll();
		List<Actor> list = (List<Actor>) iterable;
		list.sort((t1, t2) -> t1.getActorName().compareTo(t2.getActorName()));
		return list;
	}

	@Override //Sorting using Collections
	public Iterable<Actor> getAllActorsInSorting2() {
		Iterable<Actor> iterable = actorRepo.findAll();
		List<Actor> list = (List<Actor>) iterable;
		Collections.sort(list, (t1, t2) -> t1.getActorName().compareTo(t2.getActorName()));
		return list;
	}

	@Override //Sorting using Streams
	public Iterable<Actor> getAllActorsInSorting3() {
		Iterable<Actor> iterable = actorRepo.findAll();
		List<Actor> list = StreamSupport.stream(iterable.spliterator(), false)
				.sorted((t1, t2) -> t1.getActorName().compareTo(t2.getActorName())).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<Actor> fetchActorsByCategories(String category1, String category2) {
		List<Actor> actorsList = actorRepo.getActorsByCategories(category1, category2);
		return actorsList;
	}

	@Override
	public String updateActor(Actor actor) {
		Integer actorId = actor.getActorId();
		Optional<Actor> optional = actorRepo.findById(actorId);
		if (optional.isPresent()) {
			actorRepo.save(actor);
			return "Actor record updated";
		} else {
			throw new ActorNotFoundException("No actor is available with id " + actorId + " provided");
		}
	}

	@Override
	public String deleteActor(Integer id) {
		Optional<Actor> optional = actorRepo.findById(id);
		if (optional.isPresent()) {
			Actor actor = optional.get();
			actorRepo.delete(actor);
			return "Actor with id " + id + " is deleted";
		} else {
			throw new ActorNotFoundException("No actor is available with id " + id + " provided");
		}
	}

	@Override
	public String updateActorMobileNo(Integer id,long newMobileNo) {
		Optional<Actor> optional = actorRepo.findById(id);
		if (optional.isPresent()) {
			Actor actor = optional.get();
			actor.setMobileNo(newMobileNo);
			return "Actor's mobile number is updated";
		} else {
			throw new ActorNotFoundException("No actor is available with id " + id + " provided");
		}
	}

}
