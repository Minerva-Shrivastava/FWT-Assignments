package com.yash.moviebookingapp.exception;

public class ScreenRepositoryEmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScreenRepositoryEmptyException(String message) {
		super(message);
	}
}
