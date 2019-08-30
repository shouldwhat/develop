package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface MapConvertable {
	
	default Map<String, Object> toMap() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Stream.of(this.getClass().getDeclaredFields()).forEach(field -> {

			field.setAccessible(true);
			
			try {  result.put(field.getName(), field.get(this)); } 
			catch (IllegalArgumentException | IllegalAccessException e) { e.printStackTrace(); }
		});
		
		return result;
	}
}
