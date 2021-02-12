package com.maik.demo.entity;

import java.util.ArrayList;

public class Warenkorb {
	private int anzahl;
	private ArrayList<Artikel>artikelImWarenkorb;
	
	public Warenkorb() {
		System.out.println("neuen Warenkorb erstellt!");
		this.anzahl=0;
		this.artikelImWarenkorb=new ArrayList<>();
	}

	public int getAnzahl() {
		return this.anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public ArrayList<Artikel> getArtikelImWarenkorb() {
		return this.artikelImWarenkorb;
	}

	public void setArtikelImWarenkorb(ArrayList<Artikel> artikelImWarenkorb) {
		this.artikelImWarenkorb = artikelImWarenkorb;
	}
	
	public void artikelHinzufuegen(Artikel newArtikel) {
		if( newArtikel != null ) {
			this.artikelImWarenkorb.add(newArtikel);
			this.setAnzahl(this.artikelImWarenkorb.size());
		} else {
			System.out.println("Der Artikel ist leer...");
		}
		
	}
}
