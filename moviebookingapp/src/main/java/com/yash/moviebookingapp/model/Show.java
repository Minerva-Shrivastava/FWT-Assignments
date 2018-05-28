package com.yash.moviebookingapp.model;


import java.sql.Time;
import java.util.*;

public class Show {

	private int id;
	private String name;
	private Date showDate;
	private Time showTime;
	private Movie movie;
	
	public Show() {
		super();
	}

	public Show(int id, String name, Date showDate, Time showTime, Movie movie) {
		super();
		this.id = id;
		this.name = name;
		this.showDate = showDate;
		this.showTime = showTime;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int idl) {
		this.id = idl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", name=" + name + ", showDate=" + showDate + ", showTime=" + showTime + ", movie="
				+ movie + "]";
	}
	
	
	
}
