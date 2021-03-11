package IngerGYM;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.Opinion;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.servicios.ServicioClases;
import IngerGYM.servicios.ServicioClientes;


@Controller
public class ClasesController {
	@Autowired
	private ServicioClientes servicioClases;
	@Autowired
	private RepositorioClientes repositorio;
	
	@PostMapping("/clase")
	public String enviarOpinion(Model model){
		
		
		List<Clases> clases= servicioClases.getClases();
		
		model.addAttribute("clasesDisponibles",clases);
		
		return "clase";
		
	}
	@PostMapping("/suscribirse")
	public String suscribirse(@RequestParam String nombres,HttpSession sesion){
		String nombre=(String)sesion.getAttribute("nombreActual");
		
		int m=servicioClases.posCliente(nombre);
		Cliente cliente=servicioClases.getCliente(m);
		
		
		//List<Clases> clases= servicioClases.getClases();
		
		int n=servicioClases.posClase(nombres);
		
		Clases clase=servicioClases.getClase(n);
		
		cliente.addClass(clase);
		
		
		repositorio.delete(cliente);
		repositorio.save(cliente);
		
		if(clase.getName().equals("Piscina")) {
			servicioClases.reservarPiscina(clase.getDia(), clase.getHora());
		}
		if(clase.getName().equals("Gym")) {
			servicioClases.reservarGimnasio(clase.getDia(), clase.getHora());
		}
		if(clase.getName().equals("Zumba")) {
			servicioClases.reservarZumba(clase.getDia(), clase.getHora());
		}
		
		return "ReservaRealizada";
		
	}
	@PostMapping("/verClase")
	public String verClases(Model model,HttpSession sesion){
		String nombre=(String)sesion.getAttribute("nombreActual");
		
		int m=servicioClases.posCliente(nombre);
		Cliente cliente=servicioClases.getCliente(m);
		
		List<Clases> clases= cliente.getListaClases();
		
		model.addAttribute("clases",clases);
		
		return "verClases";
		
	}
}