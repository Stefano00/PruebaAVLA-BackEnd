package com.avla.pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.avla.pruebatecnica.config.JwtTokenProvider;
import com.avla.pruebatecnica.exception.RestServiceException;
import com.avla.pruebatecnica.model.User;
import com.avla.pruebatecnica.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	// constructor
	@Autowired
	public UserServiceImpl(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signIn(User user) {
			try {
				System.out.println("INGRESEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			return jwtTokenProvider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).getRole());
		} catch (AuthenticationException e) {
			throw new RestServiceException("username o password invalido", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public String signUp(User user) {
		System.out.println("creando usuario ");
		if (!userRepository.existsByUsername(user.getUsername())) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return jwtTokenProvider.createToken(user.getUsername(), user.getRole());
		
	} else {

		throw new RestServiceException("Username ya está en uso", HttpStatus.UNPROCESSABLE_ENTITY);
	}
	}

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
