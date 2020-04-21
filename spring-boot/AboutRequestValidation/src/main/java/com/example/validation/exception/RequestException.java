package com.example.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestException(String message) {
		super(message);
	}
}
