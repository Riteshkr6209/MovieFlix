package com.Movie.reporesitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

//	Method to find user by using the email
	public User findByEmail(String email);
	public void deleteByEmail(String email);

}
