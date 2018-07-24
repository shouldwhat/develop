package com.example.validation.control;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.entity.Hello;
import com.example.validation.entity.World;
import com.example.validation.exception.RequestException;

@RestController
public class SmartController {

	private static final Logger LOG = LoggerFactory.getLogger(SmartController.class);
	
	@GetMapping(value = "/hello")
	public void hello(HttpServletRequest request, 
			@Valid Hello query,
			Errors errors) throws RequestException {
		
		if(errors.hasErrors()) {
			
			List<String> errorFields = errors.getFieldErrors().stream()
					.map(FieldError::getField)
					.collect(Collectors.toList());
			
			throw new RequestException(errorFields.toString());
		}
		
		LOG.debug("`e` hello.query = {}", query);
	}
	
	@PostMapping(value = "/world")
	public void world(HttpServletRequest request, @RequestBody World body) {
		LOG.debug("`e` hello.body = {}", body);
	}
}
