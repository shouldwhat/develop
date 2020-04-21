package com.example.demo.service.base;

import com.example.demo.exception.ServiceException;

public interface ExceptionInvokeService {

	public void invokeException() throws Exception;
	
	public void invokeServiceException() throws Exception;
	
	public void invokeArithmeticException() throws Exception;
	
	public void doSomething() throws ServiceException;
}
