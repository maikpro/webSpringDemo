package com.maik.demo.entity;

public class Artikel {
	private int id;
	private String name;
	private String beschreibung;
	private double preis;
	
	private String bild;
	
	//Ohne Bild
	public Artikel(int id, String name, String beschreibung, double preis) {
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
	}
	
	//Mit Bild
	public Artikel(int id, String name, String beschreibung, double preis, String imagePath) {
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
		
		this.bild = imagePath;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getPreis() {
		return this.preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	

	public String getBild() {
		return this.bild;
	}

	public void setBild(String bild) {
		this.bild = bild;
	}

	@Override
	public String toString() {
		return "Artikel [getId()=" + getId() + ", getName()=" + getName() + ", getBeschreibung()=" + getBeschreibung()
				+ ", getPreis()=" + getPreis() + "]";
	}
}
