package com.Movie.reporesitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
