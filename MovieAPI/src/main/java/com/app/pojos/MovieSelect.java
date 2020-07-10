package com.app.pojos;

import java.util.List;

public class MovieSelect {

	private int count;

	private List<Movie> list_movie;
	
	public MovieSelect() {
	}

	public MovieSelect(int count, List<Movie> list_movie) {
		super();
		this.count = count;
		this.list_movie = list_movie;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Movie> getList_movie() {
		return list_movie;
	}

	public void setList_movie(List<Movie> list_movie) {
		this.list_movie = list_movie;
	}
	
	
}
