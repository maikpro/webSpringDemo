package com.ooad.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ooad.demo.entity.Artikel;
import com.ooad.demo.entity.ArtikelLager;
import com.ooad.demo.entity.Warenkorb;

/** BasicRoutingController
 * @author Maik Proba(Hauptverantwortlich), Marcel Sauer, Hafiyyan Teh
 * @version 1.0
 */

@Controller
@SessionAttributes("ArtikelImLager")
public class BasicRoutingController {
	private ArtikelLager artikelLager =  new ArtikelLager();
	
	/**
	 * @return artikelLager wird erzeugt und als ModelAttribut verwendet. 
	 * Das ArtikelLager-Objekt wird innerhalb der Controller (BasicRoutingController und WarenkorbController) verwendet als SessionAttribute.
	 * */
	@ModelAttribute("ArtikelImLager")
	public ArtikelLager artikelLager() {
		return artikelLager;
	}
	
	/**
	 * getArtikelById wird aufgerufen, wenn der Client die URL /artikel/{id} aufruft. {id} ist hierbei der ausgewählte Artikel.
	 * @param artikelLager enthaelt alle erzeugten Artikel zur Laufzeit.
	 * @param id enthaelt die id des aufgerufenen Artikels.
	 * @param model hält den Artikel mit der gewissen id.
	 * @return wenn Client die URL /artikel/{id} aufruft wird der View "artikel" ausgegeben und dem Client wird im Browser der jeweilige Artikel mit der ID angezeigt.
	 * */
	@GetMapping("/artikel/{id}")
	public String getArtikelById(@ModelAttribute("ArtikelImLager") ArtikelLager artikelLager, @PathVariable("id") int id, Model model) {
		Artikel viewArtikel = artikelLager.getArtikelMap().get(id);
		model.addAttribute("artikel", viewArtikel);
		return "artikel"; //Ausgabe von artikel.html
	}
	
	/**
	 * home wird aufgerufen, wenn der Client die URL / aufruft.
	 * @param artikelLager enthaelt alle erzeugten Artikel zur Laufzeit.
	 * @param model bekommt die artikelListe übergeben mit addAttribute.
	 * @return wenn Client die URL / aufruft wird der View "index" ausgegeben und dem Client wird im Browser index.html angezeigt mit allen Artikeln, die im ArtikelLager in artikelListe enthalten sind.
	 * */
	@GetMapping("/")
	public String home( @ModelAttribute("ArtikelImLager") ArtikelLager artikelLager, Model model ) {
		model.addAttribute("artikelListe", artikelLager.getArtikelListe());
		return "index"; //Ausgabe von index.html
	}
	
	/**
	 * about wird aufgerufen, wenn der Client die URL /about aufruft.
	 * @param model bekommt einen Text übergeben, der oben auf der Seite angezeigt wird.
	 * @return wenn Client die URL /about aufruft wird der View "about" ausgegeben und dem Client wird im Browser about.html angezeigt.
	 * */
	@GetMapping("/about")
	public String about(Model model) {
		String aboutText = "Dieses Projekt wurde für die Hausarbeit vom Modul OOAD entwickelt, um das Java Spring Framework in seinen Funktionen zu testen und zu nutzen.";
		model.addAttribute("aboutText", aboutText);
		return "about"; //Ausgabe von about.html
	}
	
	/**
	 * login wird aufgerufen, wenn der Client noch nicht eingeloggt ist.
	 * @return wenn Client noch nicht eingeloggt ist, wird der View "login" ausgegeben und dem Client wird im Browser login.html angezeigt mit dem Login-Form.
	 * */
	@GetMapping("/login")
	public String login() {
		return "login"; //Ausgabe von login.html
	}
	
	/**
	 * einstellen wird aufgerufen, wenn der Client die URL /artikelEinstellen aufruft.
	 * @return wenn der Client die URL /artikelEinstellen aufruft, wird im Browser artikelErstellen.html angezeigt mit dem Artikel-Form.
	 * */
	@GetMapping("/artikelEinstellen")
	public String einstellen() {
		return "artikelEinstellen";
	}
	
	
	/**
	 * chat wird aufgerufen, wenn der Client die URL /chat aufruft.
	 * @return wenn der Client die URL /chat aufruft, wird im Browser chat.html angezeigt mit der Chat-Form.
	 * */
	@GetMapping("/chat")
	public String chat() {
		return "chat"; //Ausgabe von chat.html
	}
	
	/**
	 * warenkorb wird aufgerufen, wenn der Client die URL /warenkorb aufruft.
	 * @param warenkorb Warenkorb-Objekt mit allen Artikeln, die sich zum jeweiligen Zeitpunkt im Warenkorb befinden. Es wird hier als SessionAttribute übergeben.
	 * @param model bekommt alle Artikel im Warenkorb übergeben und den Gesamtpreis.
	 * @return wenn der Client die URL /warenkorb aufruft, wird im Browser warenkorb.html angezeigt mit allen Artikeln, die im Warenkorb liegen und aus allen Preisen wird der Gesamtpreis berechnet.
	 * */
	@GetMapping("/warenkorb")
	public String warenkorb(@SessionAttribute("warenkorb") Warenkorb warenkorb, Model model) {
		model.addAttribute("artikelAusWarenkorb", warenkorb.getArtikelImWarenkorb());
		model.addAttribute("gesamtPreis", warenkorb.preisInsgesamt());
		return "warenkorb";
	}
	
	/**
	 * error wird aufgerufen, falls beim Routing der URL oder im generell im Backend ein Fehler passiert.
	 * @return gibt die Webseite error.html aus als View.
	 * */
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	
	
	
}
