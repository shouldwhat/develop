package com.example.demo.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service("retryService")
public class RetryService implements InitializingBean {
	
	private static final Logger LOG = LoggerFactory.getLogger(RetryService.class);
	
	@Retryable(maxAttempts = 5, value = ArithmeticException.class, backoff = @Backoff(delay = 1000))
	public void call(Map<String, Object> param) {
		
		LOG.debug("TService.call() call...");
		
		/* invoke exception */
		int result = 2/0;
	}
	
	@Recover
	public void recover(Exception e, Map<String, Object> param) {
		
		LOG.debug("TService.recover() call...");
		
		LOG.debug("param => {}", param);
		LOG.debug("e => {}", e);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.debug("TService.init...");
	}
}
