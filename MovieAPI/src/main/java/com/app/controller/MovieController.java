package com.app.controller;

import java.time.LocalDate;
import java.time.Month;
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
import com.app.pojos.MovieSelect;
import com.app.service.MovieService;
@Controller
@RequestMapping("/movie")
public class MovieController {

	@PostMapping("/SetMovieList")
	public ResponseEntity<MovieSelect> setMovieList(@RequestBody MovieList movieList) {
		List<Movie> list_movies = movieList.getList();
		Integer[][] dates = MovieService.calculateDates(list_movies);
		MovieSelect selected_movies=MovieService.calculateMaxSalary(list_movies, dates);
		
		return new ResponseEntity<MovieSelect> (selected_movies,HttpStatus.OK);
	}
	
}
