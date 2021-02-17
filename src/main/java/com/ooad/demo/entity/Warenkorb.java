package com.ooad.demo.entity;

import java.util.ArrayList;

/** Warenkorb
 * @author Marcel Sauer (Hauptverantwortlich), Maik Proba, Hafiyyan Teh
 * @version 1.0
 */

public class Warenkorb {
	private int anzahl;
	private ArrayList<Artikel>artikelImWarenkorb;
	
	public Warenkorb() {
		System.out.println("neuen Warenkorb erstellt!");
		this.anzahl=0;
		this.artikelImWarenkorb=new ArrayList<>();
	}
	
	/**
	 * 
	 * @return gibt die Anzahl der Artikeln im Warenkorb zurück
	 */
	public int getAnzahl() {
		return this.anzahl;
	}
	
	/**
	 * 
	 * @param anzahl setzt die Anzahl der Artikeln im Warenkorb.
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	/**
	 * 
	 * @return gibt die Liste der Artikeln im Warenkorb aus.
	 */
	public ArrayList<Artikel> getArtikelImWarenkorb() {
		return this.artikelImWarenkorb;
	}
	
	/**
	 * 
	 * @param artikelImWarenkorb setzt den Warenkorb fest.
	 */
	public void setArtikelImWarenkorb(ArrayList<Artikel> artikelImWarenkorb) {
		this.artikelImWarenkorb = artikelImWarenkorb;
	}
	
	/**
	 * 
	 * @param newArtikel ein neuer Artikel wird in den Warenkorb gelegt.
	 */
	public void artikelHinzufuegen(Artikel newArtikel) {
		if( newArtikel != null ) {
			this.artikelImWarenkorb.add(newArtikel);
			this.setAnzahl(this.artikelImWarenkorb.size());
		} else {
			System.out.println("Der Artikel ist leer...");
		}
		
	}
	
	/**
	 * 
	 * @return gibt die gesamten Preis aller Artikel im Warenkorb aus.
	 */
	public double preisInsgesamt() {
		double ergebnis=0;
		for(Artikel artikel : this.artikelImWarenkorb) {
			ergebnis += artikel.getPreis();
		}
		return ergebnis;
	}
}
