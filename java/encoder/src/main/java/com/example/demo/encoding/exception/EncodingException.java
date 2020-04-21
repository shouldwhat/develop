package com.example.demo.encoding.exception;

public class EncodingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncodingException() {
		
	}
	
	public EncodingException(String message) {
		super(message);
	}
	
	public EncodingException(String message, Exception e) {
		super(message, e);
	}
}
