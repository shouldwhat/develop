package com.example.demo.encoding.encoder.factory.conf;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.encoding.encoder.factory.EncoderFactory;

@Configuration
public class EncoderConfiguration {

	@Bean("encoderServiceLocatorFactoryBean")
	public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
		
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(EncoderFactory.class);
        
        return serviceLocatorFactoryBean;
	}
}
