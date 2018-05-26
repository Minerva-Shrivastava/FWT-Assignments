package com.yash.moviebookingapp.exception;

public class MovieRepositoryEmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieRepositoryEmptyException(String message) {
		super(message);
	}
}
