package com.example.demo.interceptor.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.TestInterceptor;

@Configuration
public class InterceptorConfiguration implements InitializingBean, WebMvcConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(InterceptorConfiguration.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.debug("----------------------------------------------------------------------------------------------------------------");
		LOG.debug("[{}] has initialized...", this.getClass().getCanonicalName());
		LOG.debug("----------------------------------------------------------------------------------------------------------------");
	}
	
	@Bean
	public TestInterceptor testInterceptor() {
		return new TestInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor()).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
