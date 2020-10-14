package com.avla.pruebatecnica.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avla.pruebatecnica.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);
	boolean existsByUsername(String username);
		
}
