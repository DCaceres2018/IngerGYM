package com.example.ej1spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnuncioController {

	@PostMapping("/guardaranuncio")
	public String guardarAnuncio(Model model, @RequestParam String nombre, @RequestParam String asunto) {

		model.addAttribute("nombre", nombre);
		model.addAttribute("asunto", asunto);
		

		return "anuncio";
	}
}
/*

prueba para commits
asdasdzxczxc
*/