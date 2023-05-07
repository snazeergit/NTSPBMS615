package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.model.PersonDetails;

public interface IPersonService extends UserDetailsService {
	public String register(PersonDetails details);
}
