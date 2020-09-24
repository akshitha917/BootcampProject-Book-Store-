package com.cg.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InputInvalidException extends Exception {
	
	public InputInvalidException(String message) {
		super(message);
	}

}
