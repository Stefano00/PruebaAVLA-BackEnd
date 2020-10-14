package com.avla.pruebatecnica.service;

import java.util.List;

import com.avla.pruebatecnica.model.Task;

public interface ITaskService {

	List<Task> findAll();
	void createTask(Task task);
	void markTasks(Task task);
	void deleteTask(Task task);
	void editTask(Task task);
	Task findById(Integer id);
}
