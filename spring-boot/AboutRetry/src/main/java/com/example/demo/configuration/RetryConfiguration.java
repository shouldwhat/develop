package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfiguration implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(RetryConfiguration.class);

//	@Bean
//	public RetryTemplate retryTemplate() {
//		
//		RetryTemplate retryTemplate = new RetryTemplate();
//		{
//			FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
//			fixedBackOffPolicy.setBackOffPeriod(2000L);
//			
//			SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//			retryPolicy.setMaxAttempts(5);
//			
//			retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
//			retryTemplate.setRetryPolicy(retryPolicy);
//		}
//		
//		return retryTemplate; 
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.debug("TConfiguration loaded...");
	}
}
