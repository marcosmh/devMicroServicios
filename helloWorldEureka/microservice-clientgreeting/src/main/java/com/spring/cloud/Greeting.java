package com.spring.cloud;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Greeting")
public class Greeting {
	
	protected String content;
	
	protected Greeting() {
		this.content = "Hellow!";
	}
	
	public Greeting(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

}
