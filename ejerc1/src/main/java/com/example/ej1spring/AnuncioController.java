package com.example.ej1spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/salas")
	public String salas() {

		

		return "sala";
	}
	
	@PostMapping("/registro")
	public String registro() {

		

		return "registro";
	}
	
}
