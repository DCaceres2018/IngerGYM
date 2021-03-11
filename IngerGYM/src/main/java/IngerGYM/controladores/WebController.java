package IngerGYM.controladores;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.Tarifa;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.servicios.ServicioTarifas;

@Controller
public class WebController {
	
	@Autowired
	private ServicioClientes servicioCliente;
	
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	
	@Autowired
	private ServicioTarifas servicioTarifas;
	
	@PostConstruct
	public void init() {
		/*Cliente cliente=new Cliente("carlos","email",5,"123");
		clienteS.save(cliente);*/
	}
	
	@GetMapping("/")
	public String mostrarPagPrincipal(){
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String usuario, @RequestParam String contraseña, HttpSession sesion) {
	
		//Comprobamos que existe
		Cliente clienteActual=servicioCliente.findByNombre(usuario);
		if (clienteActual!=null) {
			sesion.setAttribute("usuarioActual", clienteActual);
			sesion.setAttribute("nombreActual", usuario);
			model.addAttribute("clienteActual",clienteActual);
			return "bienvenidos";
		}else {
			return "index";
		}
		
	}

	
	@GetMapping("/bienvenido")
	public String login(Model model,HttpSession sesion) {
	
		Cliente clienteActual= (Cliente) sesion.getAttribute("usuarioActual");
		model.addAttribute("clienteActual",clienteActual);
		return "bienvenidos";
	}
	
	@PostMapping("/usuariosDisponibles")
	public String listarUsuarios(Model model) {
	
		model.addAttribute("clientes",servicioCliente.findAll());
		
		return "usuariosDisponibles";
	}
	
	@GetMapping("/usuariosDisponibles/{id}")
	public String listarUsuarios(Model model,HttpSession sesion) {
	
		model.addAttribute("clientes",servicioCliente.findAll());
		
		Cliente clienteActual= (Cliente) sesion.getAttribute("usuarioActual");
		model.addAttribute("clienteActual",clienteActual);
		
		return "usuariosDisponibles";
	}
	
	@GetMapping("/clientes/{id}")
	public String mostrarUsuario(Model model, @PathVariable long id) {

		model.addAttribute("cliente",servicioCliente.findById(id));
		
		return "datosCliente";
	}
	
	@GetMapping("/clientes/{id}/darDeBaja")
	public String darDeBaja(Model model, @PathVariable long id,HttpSession sesion) {

	
		Cliente cliente=servicioCliente.findById(id);
		model.addAttribute("clienteActual",cliente);
		
		if(servicioOpiniones.deleteByUserId(id)==1) {
			return "eliminadoCorrectamente";
		}else {
			servicioCliente.deleteById(id);
			return "eliminadoCorrectamente";
		}
	}
	
	@PostMapping("/tarifa")
	public String tarifa(Model model,HttpSession sesion) {
		List<Tarifa> tarifas= servicioTarifas.findAll();
		model.addAttribute("tarifas",tarifas);
		
		return "tarifa";
	}

	@PostMapping("/horario")
	public String horario() {

		return "horario";
	}
	
}