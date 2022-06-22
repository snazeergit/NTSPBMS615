package com.nt.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return iterable;
	}

	@Override //Sorting using Collections
	public Iterable<Actor> getAllActorsInSorting2() {
		Iterable<Actor> iterable = actorRepo.findAll();
		List<Actor> list = (List<Actor>) iterable;
		Collections.sort(list, (t1, t2) -> t1.getActorName().compareTo(t2.getActorName()));
		return iterable;
	}

	@Override //Sorting using Streams
	public Iterable<Actor> getAllActorsInSorting3() {
		Iterable<Actor> iterable = actorRepo.findAll();
		List<Actor> list = StreamSupport.stream(iterable.spliterator(), false)
				.sorted((t1, t2) -> t1.getActorName().compareTo(t2.getActorName())).collect(Collectors.toList());
		return list;
	}

}
