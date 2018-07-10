package com.example.demo.AboutJunitTest.entity;

public class User {

	private String name;
	private Integer age;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	public User(String name, Integer age) {
		this.setName(name);
		this.setAge(age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
