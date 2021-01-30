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
		Artikel artikel1 = new Artikel(1, "Nike Schuhe", "Schuhgröße: 43", 59.99, "https://img01.ztat.net/article/spp-media-p1/0034959e2d1a3105aa6c338b9cea6ffd/28bcaf048f714eb8b66d715a43848c6b.jpg?imwidth=762&filter=packshot");
		Artikel artikel2 = new Artikel(2, "T-Shirt", "Größe: M", 19.99, "https://www.engelhorn.de/dw/image/v2/AALR_PRD/on/demandware.static/-/Sites-engelhorn-master-plattform/default/dwa4f41b57/images/P10/04/06/7B/V1070643M/engelhorn-Nike-Sportswear-Herren-T-Shirt-Club-Vorderansicht-V1070643M-v1.jpg?sw=365&sh=438&sm=fit");	
		Artikel artikel3 = new Artikel(3, "Hose", "Größe: 30/30", 29.99, "https://www.engelhorn.de/dw/image/v2/AALR_PRD/on/demandware.static/-/Sites-engelhorn-master-plattform/default/dwceec5004/images/P10/04/06/6K/V1005619W/engelhorn-Nike-Sportswear-Herren-Sweathose-Club-Vorderansicht-V1005619W-v1.jpg?sw=365&sh=438&sm=fit");
		this.artikelListe.add(artikel1);
		this.artikelListe.add(artikel2);
		this.artikelListe.add(artikel3);
	}
	
	@GetMapping("/artikel/{id}")
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
