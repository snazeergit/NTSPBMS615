package com.nt.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.repository.IUserDetailsRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDetailsRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Get model class object(com.nt.model.UserDetails)
		Optional<com.nt.model.UserDetails> optional = repo.findByUname(username);
		if (optional.isEmpty()) {
			throw new IllegalArgumentException(username + " user not found");
		} else {
			com.nt.model.UserDetails details = optional.get();
			
			/*//Converting Set<String> type roles to Set<SinpleGrantAuthority> type roles
			Set<SimpleGrantedAuthority> roles1=new HashSet<>();
			Set<String> roles2 = details.getRoles();
			for (String role : roles2) {
				roles1.add(new SimpleGrantedAuthority(role));
			}
			User user = new User(details.getUname(), details.getPwd(),roles1);*/
			
			User user = new User(details.getUname(), details.getPwd(),
					//LAMBDA Expression + Stream API to convert Set<String> to Set<SimpleGrantedAuthority>
					details.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
							.collect(Collectors.toSet()));
			return user;
		}
	}

	@Override
	public String register(com.nt.model.UserDetails details) {
		details.setPwd(encoder.encode(details.getPwd()));
		return repo.save(details).getUnid() + " user id is registered";
	}

}
