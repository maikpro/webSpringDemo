package com.ooad.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ooad.demo.entity.ArtikelLager;
import com.ooad.demo.entity.Warenkorb;

//Quelle: https://spring.io/guides/tutorials/rest/ , abgerufen am 12.02.2021
//Quelle: https://www.javadevjournal.com/spring-mvc/spring-mvc-session-attributes/ , abgerufen am 12.02.2021

/** WarenkorbController
 * @author Maik Proba(Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

@RestController
@SessionAttributes("warenkorb")
public class WarenkorbController {
	
	/**
	 * @return Objekt Warenkorb wird erzeugt und als ModelAttribut verwendet. 
	 * Das Warenkorb-Objekt wird innerhalb der Controller (BasicRoutingController und WarenkorbController) verwendet als SessionAttribute.
	 * */
	@ModelAttribute("warenkorb")
	public Warenkorb warenkorb() {
		return new Warenkorb();
	}
	
	/**
	 * getWarenkorbAnzahl wird vom JavaScript warenkorb.js mit der Methode aktualisiereWarenkorbImClient() aufgerufen, um die Anzahl des Warenkorbs korrekt darzustellen.
	 * @param warenkorb enthaelt alle Artikel, die sich zur Laufzeit im Warenkorb befinden.
	 * @return gibt die Anzahl der Artikel, die sich im Warenkorb befinden zurück.
	 * 
	 * */
	@GetMapping("/api/get/warenkorb/")
	public int getWarenkorbAnzahl(@ModelAttribute("warenkorb") Warenkorb warenkorb) {
		return warenkorb.getAnzahl();
	}
	
	/**
	 * packeArtikelInWarenkorb wird vom Client ausgelöst sobald er den Button In den Warenkorb tätigt,
	 * daraufhin wird das Javascript warenkorb.js mit der Methode artikelInWarenkorbLegen()
	 * @param id enthaelt die id des Artikels, der in den Warenkorb gelegt werden soll
	 * @param warenkorb enthält alle Artikel, die vom Client in den Warenkorb gelegt hat.
	 * @param artikelLager enthält alle Artikel, die zur Laufzeit im Lager sind.
	 * @return gibt einen Response an den Client zurück, dass der Artikel hinzugefügt wurde.
	 */
	@PostMapping("/api/set/warenkorb/")
	public String packeArtikelInWarenkorb(@RequestBody String id, @ModelAttribute("warenkorb") Warenkorb warenkorb, @SessionAttribute("ArtikelImLager") ArtikelLager artikelLager) {
		int parsedId = Integer.parseInt(id);
		System.out.println("Artikel mit der ID: '" + parsedId + "' wurde hinzugefügt");
		warenkorb.artikelHinzufuegen( artikelLager.getArtikelMap().get(parsedId));
		return "Artikel mit ID '" + id + "' hinzugefügt!";
	}	
}
