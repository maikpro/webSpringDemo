package com.maik.demo.entity;

public class Greeting {
	private String content;
	
	public Greeting() {
		
	}
	
	public Greeting(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
