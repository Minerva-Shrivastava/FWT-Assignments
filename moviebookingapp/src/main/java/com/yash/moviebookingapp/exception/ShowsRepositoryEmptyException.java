package com.yash.moviebookingapp.exception;

public class ShowsRepositoryEmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowsRepositoryEmptyException(String message) {
		super(message);
	}
}
