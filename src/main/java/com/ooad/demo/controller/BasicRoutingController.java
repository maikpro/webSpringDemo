package com.ooad.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ooad.demo.entity.Artikel;
import com.ooad.demo.entity.ArtikelLager;
import com.ooad.demo.entity.Warenkorb;

@Controller
@SessionAttributes("ArtikelImLager")
public class BasicRoutingController {
	
	@ModelAttribute("ArtikelImLager")
	public ArtikelLager artikelLager() {
		return new ArtikelLager();
	}
	
	@GetMapping("/artikel/{id}")
	public String getArtikelById(@ModelAttribute("ArtikelImLager") ArtikelLager artikelLager, @PathVariable("id") int id, Model model) {
		//return "Artikel: " + this.artikelListe.get(id-1).toString();
		Artikel viewArtikel = artikelLager.getArtikelListe().get(id);
		model.addAttribute("artikel", viewArtikel);
		return "artikel"; //Ausgabe von artikel.html
	}
	
	
	@GetMapping("/")
	public String home( @ModelAttribute("ArtikelImLager") ArtikelLager artikelLager, @RequestParam(name="name", required=false, defaultValue="World") String name, Model model ) {
		String willkommen="Willkommen bei der Spring Demo!";
		int num=2021;
		
		model.addAttribute("name", name);
		model.addAttribute("willkommen", willkommen);
		model.addAttribute("num", num);
		model.addAttribute("artikelListe", artikelLager.getArtikelListe());
		
		return "index"; //Ausgabe von index.html
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		String aboutText = "Das ist der About Text";
		model.addAttribute("aboutText", aboutText);
		return "about"; //Ausgabe von about.html
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		String loginText = "Das ist die Login Area!";
		model.addAttribute("loginText", loginText);
		return "login"; //Ausgabe von login.html
	}
	
	@GetMapping("/artikelEinstellen")
	public String einstellen(Artikel neuerArtikel) {
		return "artikelEinstellen";
	}
	
	@GetMapping("/chat")
	public String chat(Model model) {
		String chatText = "Das ist der Chat!";
		model.addAttribute("chat", chatText);
		return "chat"; //Ausgabe von chat.html
	}
	
	@GetMapping("/warenkorb")
	public String warenkorb(@SessionAttribute("warenkorb") Warenkorb warenkorb, Model model) {
		model.addAttribute("artikelAusWarenkorb", warenkorb.getArtikelImWarenkorb());
		model.addAttribute("gesamtPreis", warenkorb.preisInsgesamt());
		return "warenkorb";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	
	
	
}
