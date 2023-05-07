package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.PersonDetails;

public interface IPersonDetailsRepo extends JpaRepository<PersonDetails, Integer> {
	//finder method
	public Optional<PersonDetails> findByUname(String uname);
}
