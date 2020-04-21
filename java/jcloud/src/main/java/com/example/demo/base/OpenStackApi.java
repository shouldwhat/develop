package com.example.demo.base;

public abstract class OpenStackApi {

	protected abstract void init();
	
	protected OpenStackApi() {
		init();
	}
}
