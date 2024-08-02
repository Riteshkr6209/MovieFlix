package com.Movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Movie.entities.Movie;
import com.Movie.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService movserv;

	@PostMapping("addmovie")
	public String addMovie(@ModelAttribute Movie mov) {
		movserv.addMovie(mov);
		return "addmoviesuccess";
	}

	@GetMapping("viewmovie")
	public String viewmovie(Model model) {
		List<Movie> movieList = movserv.viewMovie();
		model.addAttribute("movie", movieList);
		return "viewmovie";

	}
	@GetMapping("viewmovieuser")
	public String viewmovieuser(Model model) {
		List<Movie> movieList = movserv.viewMovie();
		model.addAttribute("movie", movieList);
		return "viewmovieuser";
		
	}

}
