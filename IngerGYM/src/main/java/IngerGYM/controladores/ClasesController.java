package IngerGYM.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.Salas;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.servicios.ServicioClientes;


@Controller
public class ClasesController {
	@Autowired
	private ServicioClientes servicioClases;
	@Autowired
	private RepositorioClientes repositorio;
	
	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/clase")
	public String enviarOpinion(Model model){
		
		
		List<Clases> clases= servicioClases.getClases();
		List<Clases> copia=new ArrayList<>();
		for(Clases clase:clases) {
			if(!clase.getProfesor().equals("null")) {
				copia.add(clase);
			}
		}
		
		model.addAttribute("clasesDisponibles",copia);
		
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
	
	@GetMapping("/verClases/{id}")
	public String verClases(Model model,HttpSession sesion){
		
		String nombre=(String)sesion.getAttribute("nombreActual");
		
		int m=servicioClases.posCliente(nombre);
		Cliente cliente=servicioClases.getCliente(m);
		
		List<Clases> clases= cliente.getListaClases();
		
		
		model.addAttribute("clases",clases);
		
		return "verClases";
		
	}
	
	
	@GetMapping("/crear")
	public String crear(@RequestParam String nombreSala, @RequestParam String prof, @RequestParam String tipo,@RequestParam int dia,@RequestParam int hora){
		
		int n=servicioClientes.posSala(nombreSala);
		if(n==-1) {
			return "bienvenido";
		}
		
		Salas sala=servicioClientes.getSala(n);
		Clases a=new Clases(sala,prof,tipo,dia,hora);
		servicioClientes.guardarClase(a);
		
		return "claseCreada";

	}
}