package com.ooad.demo.entity;

import java.util.Date;

import nonapi.io.github.classgraph.json.Id;

public class ChatNachricht {
	@Id
	private String id;
	private String inhalt;
	private Date zeitstempel;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
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
	public void setZeitstempel(Date zeitstempel) {
		this.zeitstempel = zeitstempel;
	}
}
