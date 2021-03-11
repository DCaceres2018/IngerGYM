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
import IngerGYM.servicios.ServicioClases;
import IngerGYM.servicios.ServicioClientes;


@Controller
public class ClasesController {

	@Autowired
	private RepositorioClientes repositorio;
	
	@Autowired
	private ServicioClientes servicioClientes;
	
	@Autowired
	private ServicioClases servicioClases;
	
	@PostMapping("/clase")
	public String mostrarClases(Model model){
		
		List<Clases> clases= servicioClases.findAll();
		List<Clases> copia= new ArrayList();
		
		
		for(Clases clase: clases) {
			if(!clase.getProfesor().equals("null")) {
				copia.add(clase);
			}
		}
		
		model.addAttribute("clasesDisponibles",copia);
		return "clase";	
	}
	
	@PostMapping("/horario")
	public String horario(Model model) {

		List<Clases> clases= servicioClases.findAll();
		List<Clases> copia= new ArrayList();
		
		
		for(Clases clase: clases) {
			if(!clase.getProfesor().equals("null")) {
				copia.add(clase);
			}
		}
		
		model.addAttribute("clasesDisponibles",copia);model.addAttribute("clasesDisponibles",servicioClases.findAll());
		
		return "horario";
	}
	
	@PostMapping("/suscribirse")
	public String suscribirse(@RequestParam String nombres,HttpSession sesion){
		
		String nombre=(String)sesion.getAttribute("nombreActual");
		
		int m=servicioClientes.posCliente(nombre);
		Cliente cliente=servicioClientes.getCliente(m);
		
		
		//List<Clases> clases= servicioClases.getClases();
		
		int n=servicioClientes.posClase(nombres);
		
		Clases clase=servicioClientes.getClase(n);
		
		cliente.addClase(clase);
		
		
		repositorio.delete(cliente);
		repositorio.save(cliente);
		
		if(clase.getName().equals("Piscina")) {
			servicioClientes.reservarPiscina(clase.getDia(), clase.getHora());
		}
		if(clase.getName().equals("Gym")) {
			servicioClientes.reservarGimnasio(clase.getDia(), clase.getHora());
		}
		
		return "ReservaRealizada";
		
	}
	
	@GetMapping("/verClases/{id}")
	public String verClases(Model model,HttpSession sesion){
		
		String nombre=(String)sesion.getAttribute("nombreActual");
		
		int m=servicioClientes.posCliente(nombre);
		Cliente cliente=servicioClientes.getCliente(m);
		
		List<Clases> clases= cliente.getClases();
		
		
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