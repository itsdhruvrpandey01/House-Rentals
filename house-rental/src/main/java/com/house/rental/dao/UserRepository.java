package com.house.rental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.house.rental.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.u_email =:u_email")
	public User getUserByName(@Param("u_email")String email);
}
