package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(locations = "classpath:/test.properties", prefix="test")
public class TestProperties
{
	private String one;
	private String two;
}
