package com.avla.pruebatecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avla.pruebatecnica.model.User;
import com.avla.pruebatecnica.service.IUserService;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LoginController {
	
	@Autowired
	IUserService userService;
	

	
	// CONSTRUCTOR
	@Autowired
	public LoginController(IUserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/home")
	public String home() {
		
		return "Hola Mundo AVLA";
	}
	
	@PostMapping("/signUp")
	@ResponseStatus(HttpStatus.CREATED)
	public String signUp(@RequestBody User user) {
		//System.out.println("se crea nuevo usuario "+user.getName());
		return userService.signUp(user);
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody User user) {
		//System.out.println(user.getUsername());
		return userService.signIn(user);
	}
	
	

}
