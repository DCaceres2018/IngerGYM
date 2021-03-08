package IngerGYM;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.entidades.*;
import IngerGYM.entidades.Opinion;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioContacto;

@Controller
public class AnuncioController {
	
	@Autowired
	private ServicioClientes servicioClientes;
	private Contacto contacto=new Contacto();
	
	@PostMapping("/inicio")
	public String principal()
	{
		return "inicio";
	}

	@PostMapping("/zumba")
	public String zumba(Model model)
	{
		int plazasDisponibles=servicioClientes.getPlazasZumba();
		model.addAttribute("aforo", plazasDisponibles);
		return "zumba";
	}
	
	@PostMapping("/aquagym")
	public String aquagym(Model model)
	{
		int plazasDisponibles=servicioClientes.getPlazasAquagym();
		model.addAttribute("aforo", plazasDisponibles);
		return "aquagym";
	}
	
	@PostMapping("/bienvenidos_")
	public String bien() {

			return "bienvenido";
	
	}
	@GetMapping("/bienvenido")
	public String anuncio(){
		
		return "bienvenido";
	}
	
	@GetMapping("/salas")
	public String salas() {

		return "sala";
	}
	
	/*@PostMapping("/contacto")
	public String cont() {

		return "contacto";
	}*/
	
	@PostMapping("/contacto")
	public String Contacto(Model model){
		
		String numero = contacto.getNumero();
		String email= contacto.getEmail();
		
		model.addAttribute("email",email);
		model.addAttribute("numero",numero);
		
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
	
	@PostMapping("/error")
	public String error() {

		return "incorrecto";
	}
	
	@PostMapping("/cerrarSesion")
	public String cerrarSesion() {

		return "cerrarSesion";
	}
	
}