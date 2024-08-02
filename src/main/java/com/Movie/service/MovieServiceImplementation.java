package com.Movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.entities.Movie;
import com.Movie.reporesitory.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	MovieRepository movrepo;

	@Override
	public String addMovie(Movie mov) {
		movrepo.save(mov);
		return "movie is added";
	}

	@Override
	public List<Movie> viewMovie() {
		List<Movie> movieList = movrepo.findAll();
		return movieList;
	}

}
