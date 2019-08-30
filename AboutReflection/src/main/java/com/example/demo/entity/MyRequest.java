package com.example.demo.entity;

import java.util.Map;

public class MyRequest extends Request {

	private String admin;
	private Map<String, Object> dns;
	private String password;
	
	@Override
	public String toString() {
		return "MyRequest [admin=" + admin + ", dns=" + dns + ", password=" + password + "]";
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Map<String, Object> getDns() {
		return dns;
	}
	public void setDns(Map<String, Object> dns) {
		this.dns = dns;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
