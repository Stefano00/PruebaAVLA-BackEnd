package com.avla.pruebatecnica.service;

import java.util.List;
import java.util.Map;

import com.avla.pruebatecnica.model.Task;
import com.avla.pruebatecnica.model.User;

public interface IUserService {

	List<User> findAll();
	User findById(Integer id);
	String signIn(User user);
	String signUp(User user);
	void edit (User user);
	List<Task> findTaskById(Integer id);
	Map<Integer, Task> userTask();
	Map<Integer, Integer> cantUserTask();
	Map<Integer, String> taskUserId();
	void delete(Integer id);
}
