package com.Movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavController {
	
	@GetMapping("map-register")
	public String mapRegister()
	{
		return "register";
	}
	
	@GetMapping("map-login")
	public String mapLogin()
	{
		return "login";
	}
	
	@GetMapping("map-addmovie")
	public String mapAddMovie() {
		return "addmovie";
	}
	
	@GetMapping("map-deleteUser")
	public String mapDeleteUser() {
		return "deleteUser";
	}
	@GetMapping("user-update-map")
	public String mapUpdateUser() {
		return "updateuser.html";
	}

}
