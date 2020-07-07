package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Movie;
import com.app.pojos.MovieList;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@GetMapping("/testGetMovie")
	public ResponseEntity<Movie> getMovie() {
		System.out.println("in movies");
		Movie newMovie = new Movie();
		newMovie.setName("Inception");
		newMovie.setGenre("SciFi");
		return new ResponseEntity<Movie> (newMovie,HttpStatus.OK);
	}
	
	@PostMapping("/testSetMovie")
	public ResponseEntity<Movie> setMovie(@RequestBody Movie movie) {
		System.out.println(movie.toString());
		return new ResponseEntity<Movie> (movie,HttpStatus.OK);
	}
	
	@GetMapping("/testGetMovieList")
	public ResponseEntity<MovieList> getMovieList() {
		System.out.println("in movies");
		MovieList movieList = new MovieList();
		List<Movie> list = new ArrayList<>();
		list.add(new Movie("Inception","Sci Fi"));
		list.add(new Movie("BatMan","Action"));
		list.add(new Movie("TGBT","Com"));
		movieList.setList(list);
		return new ResponseEntity<MovieList> (movieList,HttpStatus.OK);
	}
	
	@PostMapping("/testSetMovieList")
	public ResponseEntity<MovieList> setMovieList(@RequestBody MovieList movieList) {
		List<Movie> list = movieList.getList();
		System.out.println(list);
		return new ResponseEntity<MovieList> (movieList,HttpStatus.OK);
	}
}
