package com.yash.moviebookingapp.exception;

public class DuplicateScreenNameException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateScreenNameException(String message) {
		super(message);
	}
}
