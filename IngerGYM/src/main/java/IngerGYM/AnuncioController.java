package IngerGYM;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.entidades.*;
import IngerGYM.servicios.ServicioClientes;

@Controller
public class AnuncioController {
	
	@Autowired
	private ServicioClientes servicioClientes;

	@PostMapping("/crearSala")
	public String crearSala(){
		
		return "crearSala";
	}
	
	@PostMapping("/crear")
	public String crear(@RequestParam String nombreSala, @RequestParam String prof, @RequestParam String tipo,@RequestParam int dia,@RequestParam int hora)
	{
		int n=servicioClientes.posSala(nombreSala);
		if(n==-1) {
			return "bienvenido";
		}
		Salas sala=servicioClientes.getSala(n);
		Clases a=new Clases(sala,prof,tipo,dia,hora);
		servicioClientes.guardarClase(a);
		return "claseCreada";
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
	
	@PostMapping("/salas")
	public String salas() {

		return "sala";
	}
	
	@GetMapping("/piscina")
	public String piscina() {

		return "piscina";
	}
	
	@GetMapping("/gimnasio")
	public String gimnasio() {

		return "gimnasio";
	}
	
	@PostMapping("/contacto")
	public String Contacto(Model model){
		Contacto contacto=new Contacto();
		
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
	
	
	
	@PostMapping("/invitados")
	public String invitados() {

		return "invitados";
	}
	
	@PostMapping("/horario")
	public String horario() {

		return "horario";
	}
	
}