package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.UserDetails;

public interface IUserDetailsRepo extends JpaRepository<UserDetails, Integer> {
	//finder method
	public Optional<UserDetails> findByUname(String uname);
}
