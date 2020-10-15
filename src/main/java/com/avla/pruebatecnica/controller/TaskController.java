package com.avla.pruebatecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avla.pruebatecnica.model.Task;
import com.avla.pruebatecnica.service.ITaskService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/tasks")
public class TaskController {

	@Autowired
	ITaskService taskService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Task task) {
		taskService.createTask(task);
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> findAll(){
		
		return taskService.findAll();
	}
	
	@PostMapping("/mark")
	public void markTask(@RequestBody Task task) {
		
		taskService.markTasks(task);
	}
	
	@PostMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTask(@RequestBody Task task) {
		taskService.deleteTask(task);
	}
	
	@PostMapping("/edit")
	public void editTask(@RequestBody Task task) {
		taskService.editTask(task);
	}
	
	@GetMapping("/{id}")
	public Task findById(@PathVariable("id") Integer id) {
		
		return taskService.findById(id);
	}
}
