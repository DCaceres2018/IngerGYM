package IngerGYM.controladores;


import java.util.ArrayList;
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
import IngerGYM.servicios.ServicioClases;
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
	
	@Autowired
	private ServicioClases servicioClases;
	
	@PostConstruct
	public void init() {
		
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
	
		Cliente paco=new Cliente("paco","paco@gmail.com",54,"abcd");
		
		model.addAttribute("clientes",paco);
		
		return "bienvenidos";
	}
	
	@GetMapping("/usuariosDisponibles")
	public String listarUsuarios(Model model,HttpSession sesion) {
	
		model.addAttribute("clientes",servicioCliente.findAll());
		
		return "usuariosDisponibles";
	}
	
	@GetMapping("/clientes/{id}")
	public String mostrarUsuario(Model model, @PathVariable long id) {

		model.addAttribute("cliente",servicioCliente.findById(id));
		
		return "datosCliente";
	}
	
	@GetMapping("/clientes/{id}/darDeBaja")
	public String darDeBaja(Model model,HttpSession sesion, @PathVariable long id) {
	
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
	@GetMapping("/tarifas/{id}")
	public String tarifa2(Model model,HttpSession sesion,@PathVariable long id) {
		List<Tarifa> tarifas= servicioTarifas.findAll();
		List<Cliente> clientes= servicioCliente.findAll();
		List<Cliente> copia=new ArrayList<>();
		int edad=0;
		for(Tarifa f:tarifas) {
			if(f.getId()==id) {
				edad=f.getEdad();
				break;
			}
		}
		if(edad==24) {
			for(Cliente f:clientes) {
				if(f.getEdad()<25) {
					copia.add(f);
				}
			}
		}
		if(edad==64) {
			for(Cliente f:clientes) {
				if(f.getEdad()>=25&&f.getEdad()<65) {
					copia.add(f);
				}
			}
		}
		else {
			for(Cliente f:clientes) {
				if(f.getEdad()>=65) {
					copia.add(f);
				}
			}
		}
		
		
		
		model.addAttribute("clientes",copia);
		
		return "tarifaCopia";
	}
	
}