package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Actor;

public interface IActorRepo extends CrudRepository<Actor, Integer> {

}
