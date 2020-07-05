package com.app.pojos;

import java.time.LocalDate;

public class Movie {

	private String name;
	private String genre;
	
//	private LocalDate from;
//	private LocalDate to;
//
	public Movie() {
	}

	public Movie(String name, String genre) {
		super();
		this.name = name;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + "]";
	}
	

//
//	public Movie(String name, LocalDate from, LocalDate to) {
//		super();
//		this.name = name;
//		this.from = from;
//		this.to = to;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public LocalDate getFrom() {
//		return from;
//	}
//
//	public void setFrom(LocalDate from) {
//		this.from = from;
//	}
//
//	public LocalDate getTo() {
//		return to;
//	}
//
//	public void setTo(LocalDate to) {
//		this.to = to;
//	}

}
