package com.yash.moviebookingapp.exception;

public class FileDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileDoesNotExistException(String message) {
		super(message);
	}
}
