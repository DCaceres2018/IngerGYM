package IngerGYM.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.ComponenteCliente;
import IngerGYM.entidades.Salas;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.servicios.ServicioClases;
import IngerGYM.servicios.ServicioClientes;


@Controller
public class ClasesController {

	@Autowired
	private ComponenteCliente userComponent;
	
	@Autowired
	private RepositorioClientes repositorio;
	
	@Autowired
	private ServicioClientes servicioClientes;
	
	@Autowired
	private ServicioClases servicioClases;
	
	@GetMapping("/clase")
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
	
	@GetMapping("/horario")
	public String horario(Model model) {

		List<Clases> clases= servicioClases.findAll();
		List<Clases> copia= new ArrayList();
		
		for(Clases clase: clases) {
			if(!clase.getProfesor().equals("null")) {
				copia.add(clase);
			}
		}
		
		model.addAttribute("clasesDisponibles",copia);
		
		return "horario";
	}
	
	@PostMapping("/suscribirse")
	public String suscribirse(@RequestParam String nombres){
		
		long id = userComponent.getLoggedUser().getId();
		Cliente cliente= servicioClientes.findById(id);
		
		int n=servicioClientes.posClase(nombres);
		Clases clase=servicioClientes.getClase(n);
		cliente.addClase(clase);

		repositorio.save(cliente);
		
		if(clase.getName().equals("Piscina")) {
			servicioClientes.reservarPiscina(clase.getDia(), clase.getHora());
		}
		if(clase.getName().equals("Gym")) {
			servicioClientes.reservarGimnasio(clase.getDia(), clase.getHora());
		}
		
		return "ReservaRealizada";
		
	}
	
	@GetMapping("/verClases")
	public String verClases(Model model){
		
		Cliente clienteID = userComponent.getLoggedUser();
		Cliente cliente= servicioClientes.findById(clienteID.getId());
		
		List<Clases> clases= cliente.getClases();
		model.addAttribute("clases",clases);
		
		return "verClases";
	}
	
	@GetMapping("/crear")
	public String crear(@RequestParam String nombreSala, @RequestParam String prof, @RequestParam String tipo,@RequestParam int dia,@RequestParam int hora){
		
		int n=servicioClientes.posSala(nombreSala);
		if(n==-1) {
			return "errorCrearClase";
		}
		
		Salas sala=servicioClientes.getSala(n);
		Clases a=new Clases(sala,prof,tipo,dia,hora);
		servicioClientes.guardarClase(a);
		
		return "claseCreada";

	}
}