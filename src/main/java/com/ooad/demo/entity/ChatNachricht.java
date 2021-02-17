package com.ooad.demo.entity;

import java.util.Date;

/** ChatNachricht
 * @author Maik Proba (Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

public class ChatNachricht {
	private String inhalt;
	private Date zeitstempel;
	
	public ChatNachricht(){
		this.zeitstempel=new Date();
	}
	
	/**
	 * 
	 * @return gibt den Inhalt der Chatnachricht zurück.
	 */
	public String getInhalt() {
		return this.inhalt;
	}
	
	/**
	 * 
	 * @param inhalt der Nachricht wird gesetzt.
	 */
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	
	/**
	 * 
	 * @return gibt den Zeitstempel des Chatnachricht zurück.
	 */
	public Date getZeitstempel() {
		return this.zeitstempel;
	}
}
