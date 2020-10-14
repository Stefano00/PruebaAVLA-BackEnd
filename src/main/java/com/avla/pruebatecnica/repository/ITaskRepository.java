package com.avla.pruebatecnica.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avla.pruebatecnica.model.Task;


@Repository
public interface ITaskRepository extends CrudRepository<Task, Integer>{

	Optional<Task> findById(Integer id);

}
