package com.ooad.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ooad.demo.entity.Artikel;
import com.ooad.demo.entity.ArtikelLager;

@RestController
@SessionAttributes("ArtikelImLager")
public class ArtikelController implements WebMvcConfigurer {
	
	//redirect zur Hauptseite nach dem hinzufügen
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
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
