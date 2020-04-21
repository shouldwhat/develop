package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ServiceException;
import com.example.demo.service.base.ExceptionInvokeService;

@Service
public class ExceptionInvokeServiceImpl implements ExceptionInvokeService {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionInvokeServiceImpl.class);

	@Override
	public void invokeException() throws Exception {
		
		LOG.debug("do invoke exception");
		throw new Exception("invoke exception ... ");
	}


	@Override
	public void invokeServiceException() throws Exception {
		
		LOG.debug("do invoke service exception");
		throw new ServiceException("invoke service-exception");
	}

	@Override
	public void doSomething() throws ServiceException {
		
		LOG.debug("do something ...");
		throw new ServiceException("invoke service-exception", null);
	}


	@Override
	public void invokeArithmeticException() throws Exception {
		
		LOG.debug("do invoke 5/0 exception");
		int result = 0/5;
		LOG.debug("result = {}", result);	// this line is not work
	}

}
