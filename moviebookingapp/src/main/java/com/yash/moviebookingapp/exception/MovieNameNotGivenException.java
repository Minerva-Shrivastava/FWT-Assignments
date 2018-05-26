package com.yash.moviebookingapp.exception;

public class MovieNameNotGivenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieNameNotGivenException(String message) {
		super(message);
	}
}
