package com.avla.pruebatecnica.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.avla.pruebatecnica.config.JwtTokenProvider;
import com.avla.pruebatecnica.exception.RestServiceException;
import com.avla.pruebatecnica.model.Task;
import com.avla.pruebatecnica.model.User;
import com.avla.pruebatecnica.repository.ITaskRepository;
import com.avla.pruebatecnica.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	ITaskRepository taskRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	// constructor
	@Autowired
	public UserServiceImpl(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public String signIn(User user) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			return jwtTokenProvider.createToken(user.getUsername(),
					userRepository.findByUsername(user.getUsername()).getRoles());

		} catch (AuthenticationException e) {
			throw new RestServiceException("username o password invalido", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public String signUp(User user) {
		System.out.println("creando usuario ");
		if (!userRepository.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());

		} else {

			throw new RestServiceException("Username ya está en uso", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public void edit(User user) {
		userRepository.save(user);
	}

	@Override
	public List<Task> findTaskById(Integer id) {

		return userRepository.findById(id).get().getTasks();

	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public Map<Integer, Task> userTask() {
		Map<Integer, Task> userTask = new HashMap<Integer, Task>();
		for (User list : userRepository.findAll()) {

			for (Task taskList : list.getTasks()) {
				userTask.put(list.getId(), taskList);
			}
		}

		return userTask;
	}

	@Override
	public Map<Integer, Integer> cantUserTask() { //Clave de id User y objecto de id Task
		Map<Integer, Integer> userTask = new HashMap<Integer, Integer>();
		Integer cont = 0;
		for (User list : userRepository.findAll()) {

			if (!list.getTasks().isEmpty()) {
				for (Task taskList : list.getTasks()) {
					cont++;
					userTask.put(list.getId(), cont);
				}
			}else {
				userTask.put(list.getId(), 0);
			}
			cont = 0;

		}
		return userTask;
	}

	@Override
	public Map<Integer, String> taskUserId() {  //Clave de id Task y objecto de id User
		
		Map<Integer, String> userTask = new HashMap<Integer, String>();
		
		for (User list : userRepository.findAll()) {

			if (!list.getTasks().isEmpty()) {
				for (Task taskList : list.getTasks()) {
					
					userTask.put(taskList.getId(), list.getUsername());
				}
				
			}else {
				userTask.put(0, list.getUsername());
			}
		
		}
		return userTask;
	}

}
