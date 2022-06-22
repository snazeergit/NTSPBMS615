package com.nt.service;

import com.nt.model.Actor;

public interface IActorMgmtService {
	public String registerActor(Actor actor);
	public Iterable<Actor> getAllActors();
	public Actor getActorById(Integer id);
	public Iterable<Actor> getAllActorsInSorting1();
	public Iterable<Actor> getAllActorsInSorting2();
	public Iterable<Actor> getAllActorsInSorting3();
	
}
