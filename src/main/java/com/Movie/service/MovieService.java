package com.Movie.service;

import java.util.List;

import com.Movie.entities.Movie;

public interface MovieService {
	
	public String addMovie(Movie mov);
	
	public List<Movie> viewMovie();

}
