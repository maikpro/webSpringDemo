package com.ooad.demo.entity;

import java.util.Date;

public class ChatNachricht {
	private String inhalt;
	private Date zeitstempel;
	
	public ChatNachricht(){
		this.zeitstempel=new Date();
	}
	
	public String getInhalt() {
		return this.inhalt;
	}
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	public Date getZeitstempel() {
		return this.zeitstempel;
	}
}
