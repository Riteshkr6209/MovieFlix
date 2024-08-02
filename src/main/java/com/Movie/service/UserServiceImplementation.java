package com.Movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.entities.User;
import com.Movie.reporesitory.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepo urepo;

	public UserServiceImplementation(UserRepo urepo) {
		super();
		this.urepo = urepo;
	}

	@Override
	public String CreateUser(User ur) {
		urepo.save(ur);
		return "user is created";
	}

	@Override
	public List<User> getUser() {
		List<User> userList = urepo.findAll();
		return userList;
	}

	@Override
	public boolean emailExist(String email) {
//		checking weather the user exist with entered email
		if (urepo.findByEmail(email) == null) {
//			if user doesn't exists with entered email
			return false;
		} else {
//			otherwise return true
			return true;
		}

	}

	@Override
	public boolean checkUser(String email, String password) {
//		Checking email and getting user details from DB
		User ur = urepo.findByEmail(email);
		if (ur != null) {
			// Getting DB password of user using email
			String db_password = ur.getPassword();
			// Checking whether user entered password and DB password is same
			if (db_password.equals(password)) {
				// if same, returning true
				return true;
			} else {
				// if not same, returning false
				return false;
			}
		} else {
			return false;

		}
	}

	@Override
	public User getUserByEmail(String email) {
		User user = urepo.findByEmail(email);
		return user;
	}
	
	@Transactional
	@Override
	public void updateUser(User ur) {
		urepo.save(ur);

	}
	
	@Transactional
	@Override
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		urepo.deleteByEmail(email);
	}

}
