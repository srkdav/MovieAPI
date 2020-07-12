package com.app.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.pojos.Movie;
import com.app.pojos.MovieSelect;

public class MovieService {
	
	public static Integer[][] calculateDates(List<Movie> list_movies){
		Integer[][] dates =new Integer[list_movies.size()][2];
		int idx=0;
		for(Movie movie:list_movies) {
			LocalDate start = movie.getFrom();
			LocalDate end = movie.getTo();
			LocalDate reference_Date = LocalDate.of(2020, 01, 01);
			long start_count =  ChronoUnit.DAYS.between(reference_Date, start);
			long end_count =  ChronoUnit.DAYS.between(reference_Date, end);
			dates[idx][0]=(int)start_count;
			dates[idx][1]=(int)end_count;
			idx++;
		}
		return dates;
	}

	public static MovieSelect calculateMaxSalary(List<Movie> list_movies, Integer[][] dates) {
		List<Movie> answer_set = new ArrayList<>();
		Helper.sortDates(dates, list_movies);
		int high = dates[0][1];
		answer_set.add(list_movies.get(0));
		for(int j=1;j<dates.length;j++) {
			int low1 = dates[j][0];
			int high1 = dates[j][1];
			if(low1>high) {
				answer_set.add(list_movies.get(j));
				high=high1;
			}
		}
		MovieSelect selected_movies=new MovieSelect();
		selected_movies.setCount(answer_set.size());
		selected_movies.setList_movie(answer_set);
		return selected_movies;
	}

	
}
