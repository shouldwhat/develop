package com.example.kafkaproducerconsumerexample.model;

public class Message {

	private String message;

	public Message() {}
	public Message(String msg) {
		this.setMessage(msg);
	}
	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
