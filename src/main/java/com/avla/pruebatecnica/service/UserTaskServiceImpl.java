package com.avla.pruebatecnica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avla.pruebatecnica.model.Task;
import com.avla.pruebatecnica.model.User;
import com.avla.pruebatecnica.model.UserTask;
import com.avla.pruebatecnica.repository.IUserRepository;
import com.avla.pruebatecnica.repository.IUserTaskRepository;

@Service
public class UserTaskServiceImpl implements IUserTaskService {

	@Autowired
	IUserTaskRepository userTaskRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public void create(UserTask userTask) {  //logica de agregado de tarea a usuario
		if(!(userTask.getIdUser()==null) && !(userTask.getIdUser()==0)  ) {
			userTaskRepository.save(userTask);
		}else {
			
			Map<Integer, Integer> contUser = new HashMap<Integer, Integer>();
			Map<Integer, Integer> contUserInv = new HashMap<Integer, Integer>();
			Integer cont = 0;
			for (User list : userRepository.findAll()) {

				if (!list.getTasks().isEmpty()) {
					for (Task taskList : list.getTasks()) {
						cont++;
						contUser.put(list.getId(), cont);
					}
				}else {
					contUser.put(list.getId(), 0);
				}
				cont = 0;

			}
			List<Integer> values = new ArrayList<Integer>();
			for(Map.Entry<Integer, Integer> map : contUser.entrySet()) {
				values.add(map.getValue());
				System.out.println("clave: " + map.getKey() + " valor " + map.getValue());
				
				contUserInv.put(map.getValue(), map.getKey());
			}
			Integer minValue = Collections.min(values);
			System.out.println(minValue);
			System.out.println(contUserInv.get(minValue));
			
			userTask.setIdUser(contUserInv.get(minValue));
			userTaskRepository.save(userTask);
			
		}
		

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
