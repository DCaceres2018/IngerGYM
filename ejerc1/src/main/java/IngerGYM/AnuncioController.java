package IngerGYM;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnuncioController {
	
	@PostMapping("/inicio")
	public String principal()
	{
		return "inicio";
	}

	@PostMapping("/bienvenidos")
	public String bienvenidos() {

			return "bienvenido";	
	}
	@PostMapping("/bienvenidos_")
	public String bien() {

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
	@PostMapping("/contactoInv")
	public String contI() {
		
		return "contactoInv";
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