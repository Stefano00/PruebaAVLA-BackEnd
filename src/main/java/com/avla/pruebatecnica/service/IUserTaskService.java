package com.avla.pruebatecnica.service;

import com.avla.pruebatecnica.model.UserTask;

public interface IUserTaskService {

	void create (UserTask userTask);
	void edit (UserTask userTask);
	UserTask findTaskById(Integer id);
}
