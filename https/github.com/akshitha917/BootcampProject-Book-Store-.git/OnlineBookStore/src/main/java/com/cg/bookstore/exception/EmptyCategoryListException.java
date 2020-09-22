package com.cg.bookstore.exception;

public class EmptyCategoryListException extends Exception {
	
	/**
	 * Author      : P. Akshitha
     * Description : This is the EmptyCategoryListException exception class with constructor
	 */
	private static final long serialVersionUID = 1L;

	public EmptyCategoryListException(String message) {
		super(message);
	}

}
