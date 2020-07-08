package com.app.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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
		list.add(new Movie("Inception",LocalDate.of(2017, 05, 11),LocalDate.of(2017, Month.MAY, 15)));
		list.add(new Movie("Batman",LocalDate.of(2017, 05, 16),LocalDate.of(2017, 5, 18)));
		movieList.setList(list);
		return new ResponseEntity<MovieList> (movieList,HttpStatus.OK);
	}
	
	
	@PostMapping("/testSetMovieList")
	public ResponseEntity<MovieList> setMovieList(@RequestBody MovieList movieList) {
		List<Movie> list = movieList.getList();
		int[][] dates =new int[list.size()][2];
		int idx=0;
		for(Movie movie:list) {
			LocalDate start = movie.getFrom();
			LocalDate end = movie.getTo();
			LocalDate reference_Date = LocalDate.of(2020, 01, 01);
			long start_count =  ChronoUnit.DAYS.between(reference_Date, start);
			long end_count =  ChronoUnit.DAYS.between(reference_Date, end);
			dates[idx][0]=(int)start_count;
			dates[idx][1]=(int)end_count;
			idx++;
		}
		return new ResponseEntity<MovieList> (movieList,HttpStatus.OK);
	}
}
