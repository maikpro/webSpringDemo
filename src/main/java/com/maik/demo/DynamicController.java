package com.maik.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DynamicController {
	
	@GetMapping("/")
	public String home( @RequestParam(name="name", required=false, defaultValue="World") String name, Model model ) {
		String willkommen="Willkommen bei der Spring Demo!";
		int num=2021;
		
		model.addAttribute("name", name);
		model.addAttribute("willkommen", willkommen);
		model.addAttribute("num", num);
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		String aboutText = "Das ist der About Text";
		model.addAttribute("aboutText", aboutText);
		return "about";
	}
}
