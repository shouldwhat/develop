package com.example.validation.entity;

import javax.validation.constraints.NotEmpty;

public class Hello {

	@NotEmpty
	private String greeting;
	
	@NotEmpty(message = "topic is mandatory field")
	private String topic;

	@Override
	public String toString() {
		return "Hello [greeting=" + greeting + ", topic=" + topic + "]";
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
