package com.avla.pruebatecnica.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avla.pruebatecnica.model.Task;
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
	
	@PostMapping("/edit")
	public void edit(@RequestBody User user) {
		userService.edit(user);
	}
	
	@GetMapping("/taskById/{id}")
	public List<Task> findTaskById(@PathVariable("id") Integer id){
		return userService.findTaskById(id);
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);		
	}
	
	@GetMapping("/userTask")
	public Map<Integer, Task> userTask(){
		
		return userService.userTask();
	}
	
	@GetMapping("/cantUserTask")
	public Map<Integer, Integer> cantUserTask(){
		
		return userService.cantUserTask();
	}
	
	@GetMapping("/taskUserId")
	public Map<Integer, String> taskUserId(){
		
		return userService.taskUserId();
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Integer id) {
		
		return userService.findById(id);
	}
}
