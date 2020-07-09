package com.app.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Integer[][] dates =new Integer[list.size()][2];
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
		calculateMaxSalary(list,dates);
		return new ResponseEntity<MovieList> (movieList,HttpStatus.OK);
	}
	
	public static void calculateMaxSalary(List<Movie> list_movies, Integer[][] dates) {
		Map<String,Integer[][]> map = new HashMap<>();
		
		int i=0;
//		for(Movie movie:list_movies) {
//			map.putIfAbsent(movie.getName(), new Integer[][] {dates[i]});
//			i++;
//		}
//		Arrays.sort(dates, (i1, i2) -> Integer.compare(i1[1], i2[1]));
		List<Movie> answer_set = new ArrayList<>();
		for(int row=0;row<dates.length;row++) {
			for(int row1=row+1;row1<dates.length;row1++) {
				if(dates[row][1]>dates[row1][1]) {
					int val_low = dates[row][0];
					int val_high = dates[row][1];
					dates[row][0]=dates[row1][0];
					dates[row][1]=dates[row1][1];
					dates[row1][0]=val_low;
					dates[row1][1]=val_high;
					Movie m_low=list_movies.get(row);
					Movie m_high=list_movies.get(row1);
					list_movies.set(row, m_high);
					list_movies.set(row1, m_low);
				}
			}
		}
		
		int high = dates[0][1];
//		System.out.println(dates[0][0]+" "+dates[0][1]);
		answer_set.add(list_movies.get(0));
		for(int j=1;j<dates.length;j++) {
			int low1 = dates[j][0];
			int high1 = dates[j][1];
			if(low1>high) {
//				System.out.println(low1+" "+high1);
				answer_set.add(list_movies.get(j));
				high=high1;
			}
		}
		System.out.println(answer_set);
		
	}
}
