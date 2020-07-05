package com.app.pojos;

import java.util.List;

public class MovieList {

	List<Movie> list;

	public MovieList() {
		super();
		// TODO Auto-generated constructor stub
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
	
}
