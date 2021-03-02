package com.example.ej1spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnuncioController {

	@PostMapping("/bienvenidos")
	public String bienvenidos(Model model, @RequestParam String nombre, @RequestParam String contraseña) {

			model.addAttribute("nombre", nombre);
			model.addAttribute("asunto", contraseña);
			

			return "bienvenido";
	
	}
	@GetMapping("/bienvenido")
	public String anuncio() {
		

		return "bienvenido";
	}
	@GetMapping("/salas")
	public String salas() {

		

		return "sala";
	}
	@PostMapping("/contacto")
	public String cont() {

		

		return "contacto";
	}
	@GetMapping("/clase")
	public String clase() {

		

		return "clase";
	}
	@GetMapping("/piscina")
	public String piscina() {

		

		return "piscina";
	}
	@GetMapping("/gimnasio")
	public String gimnasio() {

		

		return "gimnasio";
	}
	
	@PostMapping("/registro")
	public String registro() {

		

		return "registro";
	}
	
	@PostMapping("/invitados")
	public String invitados() {

		

		return "invitados";
	}
	
	@PostMapping("/horario")
	public String horario() {

		

		return "horario";
	}
	
}
