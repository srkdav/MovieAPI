package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@GetMapping("/testGetMovie")
	public ResponseEntity<Movie> getMovieList() {
		System.out.println("in movies");
		Movie newMovie = new Movie();
		newMovie.setName("Inception");
		newMovie.setGenre("SciFi");
		return new ResponseEntity<Movie> (newMovie,HttpStatus.OK);
	}
	
	@PostMapping("/testSetMovie")
	public Movie setMovie(@RequestBody Movie movie) {
		System.out.println(movie.toString());
		return movie;
	}
}
