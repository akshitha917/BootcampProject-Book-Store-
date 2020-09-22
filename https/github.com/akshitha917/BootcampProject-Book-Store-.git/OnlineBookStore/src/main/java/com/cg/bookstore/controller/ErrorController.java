package com.cg.bookstore.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.cg.bookstore.entity.ErrorResponse;
import com.cg.bookstore.exception.EmptyCategoryListException;

@ControllerAdvice
@RestController
public class  ErrorController extends ResponseEntityExceptionHandler {
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { EmptyCategoryListException.class })
	public ErrorResponse EmptyCategoryListException(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.ordinal(), req.getRequestURI().toString());
	}
}