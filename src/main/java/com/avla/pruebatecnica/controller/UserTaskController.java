package com.avla.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avla.pruebatecnica.model.UserTask;
import com.avla.pruebatecnica.service.IUserTaskService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/userTask")
public class UserTaskController {
	
	@Autowired
	IUserTaskService userTaskService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody UserTask userTask) {
		userTaskService.create(userTask);
	}
	
	@PostMapping("/edit")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void edit(@RequestBody UserTask userTask) {
		userTaskService.edit(userTask);
	}
	

}
