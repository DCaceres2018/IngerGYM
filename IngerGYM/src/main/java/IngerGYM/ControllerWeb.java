package IngerGYM;


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
import IngerGYM.entidades.Opinion;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;

@Controller
public class ControllerWeb {
	
	@Autowired
	private ServicioClientes servicioCliente;
	
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	
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
			model.addAttribute("clienteActual",clienteActual);
			return "bienvenidos";
		}else {
			return "index";
		}
		
	}
/*	
	@PostMapping("/loginBack")
	public String loginBack() {

	
		return "bienvenido";
	}

	*/
	@GetMapping("/bienvenido/{id}")
	public String login(Model model,HttpSession sesion,@PathVariable long id) {
	
		Cliente clienteActual= (Cliente) sesion.getAttribute("usuarioActual");
		model.addAttribute("clienteActual",clienteActual);
		return "bienvenidos";
	}
	
	@GetMapping("/usuariosDisponibles")
	public String listarUsuarios(Model model) {
	
		model.addAttribute("clientes",servicioCliente.findAll());
		
		return "/usuariosDisponibles";
	}
	
	@GetMapping("/clientes/{id}")
	public String mostrarUsuario(Model model, @PathVariable long id) {

		model.addAttribute("cliente",servicioCliente.findById(id));
		
		return "datosCliente";
	}
	
	@GetMapping("/clientes/{id}/darDeBaja")
	public String darDeBaja(Model model, @PathVariable long id) {

		if(servicioOpiniones.deleteByUserId(id)==1) {
			return "eliminadoCorrectamente";
		}else {
			servicioCliente.deleteById(id);
			return "eliminadoCorrectamente";
		}
	}
	
	@PostMapping("/tarifa")
	public String tarifa(HttpSession sesion) {
		Cliente cliente = (Cliente) sesion.getAttribute("usuarioActual");

		if(cliente.getEdad()<18) {
			return "tarifaNiños";
		}
		else if(cliente.getEdad()>65) {
			return "tarifaAncianos";
		}
		else {
			return "tarifaAdultos";
		}
	}
	
	
	
}