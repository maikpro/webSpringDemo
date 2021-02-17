package com.ooad.demo.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ooad.demo.entity.Artikel;
import com.ooad.demo.entity.ArtikelLager;

/** ArtikelController
 * @author Maik Proba (Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

@RestController
@SessionAttributes("ArtikelImLager")
public class ArtikelController implements WebMvcConfigurer {
	
	/** Nachdem der Client einen Artikel erstellt hat, wird der HTTP-Request mit der Methode POST ausgeführt und erstelle Artikel wird aufgerufen.
	 * @param artikelLager enthaelt und sammelt alle erzeugten Artikel.
	 * @param artikelname enthaelt den Namen vom erstellten Artikel.
	 * @param artikelbeschreibung enthaelt die Beschreibung vom erstellten Artikel.
	 * @param artikelpreis enthaelt den vom erstellten Artikel.
	 * @return Der Server gibt dem Client eine Response zurück mit den Artikel-Informationen.
	 * */
	@PostMapping("/api/artikel/create/")
	public String erstelleArtikel(
			@ModelAttribute("ArtikelImLager") ArtikelLager artikelLager, 
			@RequestParam(value="name") String artikelname,
			@RequestParam(value="beschreibung") String artikelbeschreibung,
			@RequestParam(value="preis") double artikelpreis) {
		System.out.println("Artikel wird erstellt...");
		Artikel neuerArtikel = new Artikel(artikelname, artikelbeschreibung, artikelpreis);
		System.out.println("Daten: " + neuerArtikel.toString() );
		artikelLager.neuenArtikelHinzufuegen(neuerArtikel);
		return "Artikel: '"+ neuerArtikel.toString() +"' wurde erstellt";
	}
	
}
