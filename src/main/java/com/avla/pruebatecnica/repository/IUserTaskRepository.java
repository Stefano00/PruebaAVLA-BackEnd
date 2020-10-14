package com.avla.pruebatecnica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avla.pruebatecnica.model.UserTask;

@Repository
public interface IUserTaskRepository extends CrudRepository<UserTask, Integer>{

}
