package com.example.demo.asepect;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);
	
	@AfterReturning(pointcut = "execution(* com.example.demo..*.*(..)) && args(request, ..)", returning = "responseBody")
    public void hookReturnAspect(
    		JoinPoint joinPoint, 
    		HttpServletRequest request, 
    		Map<String, Object> responseBody) throws Throwable {
		
		LOG.debug("--------------- response = {}", responseBody);
	}
}
