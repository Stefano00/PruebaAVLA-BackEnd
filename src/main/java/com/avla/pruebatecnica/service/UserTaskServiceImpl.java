package com.avla.pruebatecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avla.pruebatecnica.model.UserTask;
import com.avla.pruebatecnica.repository.IUserTaskRepository;

@Service
public class UserTaskServiceImpl implements IUserTaskService {

	@Autowired
	IUserTaskRepository userTaskRepository;
	
	@Override
	public void create(UserTask userTask) {
		userTaskRepository.save(userTask);

	}

	@Override
	public void edit(UserTask userTask) {
		
		userTaskRepository.save(userTask);

	}

	@Override
	public UserTask findTaskById(Integer id) {
		
		return  userTaskRepository.findByIdTask(id);
		
	}

}
