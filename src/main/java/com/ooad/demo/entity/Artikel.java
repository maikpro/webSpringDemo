package com.ooad.demo.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Artikel {
	private static int idCount = 0;
	private int id;
	private String name;
	private String beschreibung;
	private double preis;
	private String bild;
	
	public Artikel() {
		//wird beim Erstellen verwendet (Bean-backed form= https://spring.io/guides/gs/validating-form-input/ )
	}
	
	//Ohne Bild => Platzhalter wird erstellt.
	public Artikel(String name, String beschreibung, double preis) {
		this.id = idCount++;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = "https://via.placeholder.com/450";
	}
	
	//Mit Bild
	public Artikel(String name, String beschreibung, double preis, String imagePath) {
		this.id = idCount++;
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
