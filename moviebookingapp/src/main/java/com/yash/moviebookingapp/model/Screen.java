package com.yash.moviebookingapp.model;

public class Screen {

	private int id;
	private String name;
	
	public Screen(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
