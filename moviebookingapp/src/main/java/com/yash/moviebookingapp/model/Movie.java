package com.yash.moviebookingapp.model;


import java.sql.Time;
import java.util.List;

public class Movie {

	private int id;
	private String title;
	private Time duration;
	private String production;
	private List<String> actors;
	private String screenName;
	
	public Movie(int id, String title, Time duration, String production, List<String> actors, String screenName) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.production = production;
		this.actors = actors;
		this.screenName = screenName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", duration=" + duration + ", production=" + production
				+ ", actors=" + actors + ", screenName=" + screenName + "]";
	}
	
}
