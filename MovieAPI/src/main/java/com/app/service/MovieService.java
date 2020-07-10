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
		Map<String,Integer[][]> map = new HashMap<>();
		
		int i=0;
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
