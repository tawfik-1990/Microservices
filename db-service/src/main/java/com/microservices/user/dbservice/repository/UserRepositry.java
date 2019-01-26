package com.microservices.user.dbservice.repository;



import java.util.Collection;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.user.dbservice.model.Users;

public interface UserRepositry extends JpaRepository<Users,Integer> {
	
	List<Users> findByName(String username);
	List<Users> findAll();
	List<Users> deleteByName(String username);
}
