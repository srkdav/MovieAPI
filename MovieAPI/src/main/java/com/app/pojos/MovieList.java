package com.app.pojos;

import java.util.List;

public class MovieList {

	List<Movie> list;

	public MovieList() {
		super();
	}

	public MovieList(List<Movie> list) {
		super();
		this.list = list;
	}

	public List<Movie> getList() {
		return list;
	}

	public void setList(List<Movie> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "MovieList [list=" + list + "]";
	}
	
	
	
}
