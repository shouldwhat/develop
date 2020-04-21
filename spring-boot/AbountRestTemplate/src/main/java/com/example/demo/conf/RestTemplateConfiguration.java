package com.example.demo.conf;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration implements InitializingBean {

	private static final Logger LOG = LoggerFactory.getLogger(RestTemplateConfiguration.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		LOG.debug("----------------------------------------------------------------------------");
		LOG.debug("RestTemplateConfiguration initialized ...");
		LOG.debug("----------------------------------------------------------------------------\n");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
				.rootUri("http://localhost:8080")
				.additionalInterceptors((request, body, execution) -> {
					LOG.debug("this code is execute before http request");
					return execution.execute(request, body);
				})
				.errorHandler(new ResponseErrorHandler() {
					// TODO : 알아봐야 함.
					
					@Override
					public boolean hasError(ClientHttpResponse response) throws IOException {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public void handleError(ClientHttpResponse response) throws IOException {
						// TODO Auto-generated method stub
					}
				})
				.build();
	}
}
