package com.ooad.demo.entity;


/** Artikel
 * @author Hafiyyan Teh (Hauptverantwortlich), Maik Proba, Marcel Sauer
 * @version 1.0
 */

public class Artikel {
	private static int idCount = 0;
	private int id;
	private String name;
	private String beschreibung;
	private double preis;
	private String bild;
	
	
	/**
	 * Hierbei ist das Bild des Artikels ein Platzhalter
	 * @param name: Name des Artikels.
	 * @param beschreibung: Beschreibung des Artikels.
	 * @param preis: Preis des Artikels.
	 */
	public Artikel(String name, String beschreibung, double preis) {
		this.id = idCount++;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = "https://via.placeholder.com/450";
	}
	
	/**
	 * Hierbei ist das Bild des Artikels eine URL, die beim erstellen übergeben werden kann.
	 * @param name: Name des Artikels.
	 * @param beschreibung: Beschreibung des Artikels.
	 * @param preis: Preis des Artikels.
	 * @param imagePath: die URL die zur Bild-Datei führt.
	 */
	public Artikel(String name, String beschreibung, double preis, String imagePath) {
		this.id = idCount++;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = imagePath;
	}

	/**
	 * 
	 * @return gibt die id zurück.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id setzt die Id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return gibt den Artikelnamen des Artikels zurück.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name setze den Artikelnamen des Artikels
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return gibt die Beschreibung des Artikels zurück.
	 */
	public String getBeschreibung() {
		return this.beschreibung;
	}
	
	/**
	 * 
	 * @param beschreibung setzt die Beschreibung des Artikels
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * 
	 * @return gibt den Preis des Artikels zurück.
	 */
	public double getPreis() {
		return this.preis;
	}

	/**
	 * 
	 * @param preis setzt den Preis des Artikels.
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	/**
	 * 
	 * @return gibt das Bild des Artikels zurück.
	 */
	public String getBild() {
		return this.bild;
	}

	/**
	 * 
	 * @param bild setzt das Bild des Artikels.
	 */
	public void setBild(String bild) {
		this.bild = bild;
	}

	/**
	 * @return gibt den gesamten Artikel als String aus.
	 */
	@Override
	public String toString() {
		return "Artikel [getId()=" + getId() + ", getName()=" + getName() + ", getBeschreibung()=" + getBeschreibung()
				+ ", getPreis()=" + getPreis() + "]";
	}
}
