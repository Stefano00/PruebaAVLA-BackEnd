package com.avla.pruebatecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avla.pruebatecnica.model.Task;
import com.avla.pruebatecnica.repository.ITaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	ITaskRepository taskRepository;
	
	@Override
	public List<Task> findAll() {
		
		return (List<Task>)taskRepository.findAll();
	}

	@Override
	public void markTasks(Task task) {
		Task oldTask = new Task();
		oldTask= taskRepository.findById(task.getId()).orElse(null); //almacenar datos antiguos
		oldTask.setMark(task.isMark());  // se Setea la marca que de la tarea
		taskRepository.save(task);		
	}

	@Override
	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}

	@Override
	public void editTask(Task task) {
		if(!(task.getId()==null)) {
			taskRepository.save(task);	
		}
		
	}

	@Override
	public void createTask(Task task) {
		taskRepository.save(task);
		
	}

	@Override
	public Task findById(Integer id) {
		try {
			return taskRepository.findById(id).get();
		}catch(Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
		
	}

}
