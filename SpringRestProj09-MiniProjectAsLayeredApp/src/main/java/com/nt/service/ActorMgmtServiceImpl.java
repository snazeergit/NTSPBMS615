package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Actor;
import com.nt.repository.IActorRepo;

@Service("actotMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepo actorRepo;

	@Override
	public String registerActor(Actor actor) {
		Actor actor2 = actorRepo.save(actor);
		return "Actor is registered with ID value : " + actor2.getActorId();
	}

}
