package com.app.service;

import java.util.List;

import com.app.pojos.Movie;

public class Helper {

	public static void sortDates(Integer[][] dates,List<Movie> list_movies) {
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
	}
	
}
