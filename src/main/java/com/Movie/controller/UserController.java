package com.Movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Movie.entities.Movie;
import com.Movie.entities.User;
import com.Movie.service.MovieService;
import com.Movie.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class UserController {
	@Autowired
	UserService userv;

	@Autowired
	MovieService movserv;

	@PostMapping("user-register")
	public String CreateUser(@ModelAttribute User ur) {

		boolean status = userv.emailExist(ur.getEmail());
		if (status == true) {
			return "regfail";
		} else {
			userv.CreateUser(ur);
			return "registersuccess";

		}
	}

	@PostMapping("login")
	public String checkUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		boolean loginStatus = userv.checkUser(email, password);
		if (loginStatus == true) {
			session.setAttribute("email", email);
			if (email.equals("admin@gmail.com")) {
				return "adminhome";
			} else {
				return "home";
			}
		} else {
			return "login";
		}
	}

	@GetMapping("viewuser")
	public String getUser(Model model) {
		List<User> userList = userv.getUser();
		model.addAttribute("user", userList);
		return "viewuser";
	}

	@GetMapping("exploremovies")
	public String exploremovie(Model model, HttpSession session) {
		// Getting the email from session
		String email = (String) session.getAttribute("email");
		// Getting the user details for email
		User usr = userv.getUserByEmail(email);
		// checking whether user is premium
		if (usr.isPremium() == true) {
//			 Getting the list of movies
			List<Movie> movieList = movserv.viewMovie();
//			 Adding the movie details in model
			model.addAttribute("movie", movieList);
			// if premium, show movies
			return "viewmovieuser";
		} else {
			// otherwise, make payments
			return "payment";
		}
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@GetMapping("delete-user")
	public String deleteUser(String email) {
		userv.deleteUser(email);
		return "adminhome.html";
	}
	
	@PostMapping("user-update")
	public String updateUser(@ModelAttribute User ur) {
		userv.updateUser(ur);
		return "adminhome";
	}

}
