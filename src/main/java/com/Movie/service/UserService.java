package com.Movie.service;

import java.util.List;

import com.Movie.entities.User;

public interface UserService {

	public String CreateUser(User ur);

	public boolean emailExist(String email);

	public boolean checkUser(String email, String password);

	public List<User> getUser();
	
	public User getUserByEmail(String email);
	
	public void updateUser(User ur);
	public void deleteUser(String email);

}
