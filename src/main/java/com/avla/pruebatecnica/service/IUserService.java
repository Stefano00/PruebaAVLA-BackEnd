package com.avla.pruebatecnica.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import com.avla.pruebatecnica.model.User;

public interface IUserService {

	List<User> findAll();
	String signIn(User user);
	String signUp(User user);
	
	

}
