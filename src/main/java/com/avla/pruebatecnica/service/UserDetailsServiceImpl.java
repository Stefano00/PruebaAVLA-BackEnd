package com.avla.pruebatecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avla.pruebatecnica.model.User;
import com.avla.pruebatecnica.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IUserRepository userRepository;
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario '" + username + "' noencontrado");
		}
		return org.springframework.security.core.userdetails.User//
				.withUsername(username).password(user.getPassword()).authorities(user.getRole()).accountExpired(false)
				.accountLocked(false).credentialsExpired(false).disabled(false).build();
	}
    
}