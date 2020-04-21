package com.example.demo.yaml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {
	
	private boolean booleanType;
	private Map<String, Object> objectType;
	private List<String> listType;
	private String stringType;
	
	public UserData() {
		
		this.booleanType = true;
		
		this.objectType = new HashMap<>();
		objectType.put("member1", Arrays.asList("a1", "a2"));
		objectType.put("member2", Arrays.asList("a3"));
		objectType.put("member3", "a4");
		
		this.stringType = "kyu-vm901";
		
		this.listType = new ArrayList<>();
		this.listType.add("list-member1");
		this.listType.add("list-member2");
		this.listType.add("list-member3");
		this.listType.add("list-member4");
		this.listType.add("list-member3");
	}

	public boolean isBooleanType() {
		return booleanType;
	}

	public void setBooleanType(boolean booleanType) {
		this.booleanType = booleanType;
	}

	public Map<String, Object> getObjectType() {
		return objectType;
	}

	public void setObjectType(Map<String, Object> objectType) {
		this.objectType = objectType;
	}

	public List<String> getListType() {
		return listType;
	}

	public void setListType(List<String> listType) {
		this.listType = listType;
	}

	public String getStringType() {
		return stringType;
	}

	public void setStringType(String stringType) {
		this.stringType = stringType;
	}
}
