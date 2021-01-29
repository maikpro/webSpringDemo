package com.maik.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maik.demo.entity.Artikel;

@Controller
public class DynamicController {
	private ArrayList<Artikel> artikelListe = new ArrayList<>();
	
	public DynamicController() {
		erstelleArtikel();
	}
	
	//Zum Testen erstelle statische Artikel
	private void erstelleArtikel() {
		Artikel artikel1 = new Artikel(1, "Nike Schuhe", "Schuhgröße: 43", 59.99);
		Artikel artikel2 = new Artikel(2, "T-Shirt", "Größe: M", 19.99);	
		Artikel artikel3 = new Artikel(3, "Hose", "Größe: 30/30", 29.99);
		this.artikelListe.add(artikel1);
		this.artikelListe.add(artikel2);
		this.artikelListe.add(artikel3);
	}
	
	@GetMapping("{id}")
	//@ResponseBody
	public String getArtikelById(@PathVariable("id") int id, Model model) {
		//return "Artikel: " + this.artikelListe.get(id-1).toString();
		Artikel viewArtikel = this.artikelListe.get(id-1);
		model.addAttribute("artikel", viewArtikel);
		return "artikel";
	}
	
	@GetMapping("/")
	public String home( @RequestParam(name="name", required=false, defaultValue="World") String name, Model model ) {
		String willkommen="Willkommen bei der Spring Demo!";
		int num=2021;
		
		model.addAttribute("name", name);
		model.addAttribute("willkommen", willkommen);
		model.addAttribute("num", num);
		
		//erstelleArtikel();
		
		model.addAttribute("artikelListe", this.artikelListe);
		
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		String aboutText = "Das ist der About Text";
		
		model.addAttribute("aboutText", aboutText);
		
		
		return "about";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		String loginText = "Das ist die Login Area!";
		model.addAttribute("loginText", loginText);
		return "login"; //Ausgabe von login.html
	}
}
