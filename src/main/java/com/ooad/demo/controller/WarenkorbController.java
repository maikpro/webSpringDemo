package com.ooad.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ooad.demo.entity.Artikel;
import com.ooad.demo.entity.ArtikelLager;
import com.ooad.demo.entity.Warenkorb;

//Quelle: https://spring.io/guides/tutorials/rest/ , abgerufen am 12.02.2021
//Quelle: https://www.javadevjournal.com/spring-mvc/spring-mvc-session-attributes/ , abgerufen am 12.02.2021
@RestController
@SessionAttributes("warenkorb")
public class WarenkorbController {
	
	@ModelAttribute("warenkorb")
	public Warenkorb warenkorb() {
		return new Warenkorb();
	}
	
	@GetMapping("/api/get/warenkorb/")
	public int getWarenkorbAnzahl(@ModelAttribute("warenkorb") Warenkorb warenkorb) {
		return warenkorb.getAnzahl();
	}
	
	//Der Artikel wird in den Warenkorb gelegt.
	@PostMapping("/api/set/warenkorb/")
	public String packeArtikelInWarenkorb(@RequestBody String id, @ModelAttribute("warenkorb") Warenkorb warenkorb, @SessionAttribute("ArtikelImLager") ArtikelLager artikelLager) {
		int parsedId = Integer.parseInt(id);
		System.out.println("Artikel mit der ID: '" + parsedId + "' wurde hinzugefügt");
		
		//warenkorb.artikelHinzufuegen( new Artikel(parsedId,"Test123","kp", 9999.99) );
		warenkorb.artikelHinzufuegen( artikelLager.getArtikelListe().get(parsedId) ); 
		return "Artikel mit ID '" + id + "' hinzugefügt!";
	}	
}
