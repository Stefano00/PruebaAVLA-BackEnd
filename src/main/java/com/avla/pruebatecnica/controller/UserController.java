package com.avla.pruebatecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avla.pruebatecnica.model.User;
import com.avla.pruebatecnica.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {


	@Autowired
	IUserService userService;
	
	@GetMapping("/all")
	public List<User> findAll() {
		return userService.findAll();
	}
}
