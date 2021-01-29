package com.maik.demo.entity;

public class Artikel {
	private int id;
	private String name;
	private String beschreibung;
	private double preis;
	
	public Artikel(int id, String name, String beschreibung, double preis) {
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
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

	@Override
	public String toString() {
		return "Artikel [getId()=" + getId() + ", getName()=" + getName() + ", getBeschreibung()=" + getBeschreibung()
				+ ", getPreis()=" + getPreis() + "]";
	}
}
