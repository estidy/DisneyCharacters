package com.disneyChallenge.disneyCharacters.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.disneyChallenge.disneyCharacters.dao.UserRepository;
import com.disneyChallenge.disneyCharacters.model.Profile;
import com.disneyChallenge.disneyCharacters.model.Usr;

@Service("UserDetailsService")
public class UserService implements UserDetailsService {
	@Autowired
	 private UserRepository userRepository;
	
	@Override
	@Transactional

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usr user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		var profiles = new ArrayList<GrantedAuthority>();
	    Profile profile = user.getProfile();
		profiles.add(new SimpleGrantedAuthority(profile.getName()));
		return new User(user.getUsername(), user.getPassword(), profiles);
	}

}
