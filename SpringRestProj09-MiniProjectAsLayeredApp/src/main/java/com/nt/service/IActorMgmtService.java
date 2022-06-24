package com.nt.service;

import java.util.List;

import com.nt.model.Actor;

public interface IActorMgmtService {

	public String registerActor(Actor actor);

	public Iterable<Actor> getAllActors();

	public Actor getActorById(Integer id);

	//These 3 methods are sorted using 3 different techniques in Collection, List and Streams
	public Iterable<Actor> getAllActorsInSorting1();

	public Iterable<Actor> getAllActorsInSorting2();

	public Iterable<Actor> getAllActorsInSorting3();

	public List<Actor> fetchActorsByCategories(String category1, String category2);

	public String updateActor(Actor actor);

	public String deleteActor(Integer id);

	public String updateActorMobileNo(Integer id, long newMobileNo);

}
