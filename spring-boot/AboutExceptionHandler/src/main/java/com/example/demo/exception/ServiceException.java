package com.example.demo.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code = 555;
	
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(String message, Throwable e) {
		super(message, e);
	}
	public int getCode() {
		return this.code;
	}
}
