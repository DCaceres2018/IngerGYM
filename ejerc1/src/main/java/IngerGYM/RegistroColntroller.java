package IngerGYM;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.repositorios.RepositorioClases;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.repositorios.RepositorioSalas;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.entidades.*;

@Controller
public class RegistroColntroller {
	private boolean datosIncorrectos = false;

	
	
	
	
	private String nombre;
	private String email;
	private int edad;
	private String nTelefono;
	private String contraseña;
	
	
		
	/*@PostMapping("/moco")
	public String registrarse( Cliente cliente)
	{
		return "horario";
		/*if(cliente.getUsuario().trim().equals("") || cliente.getEmail().trim().equals("")) {
			datosIncorrectos = true;
			model.addAttribute("datosIncorrectos", datosIncorrectos);
			datosIncorrectos = false;
			return "incorrecto";
		}
		
		else {
			
			if(servicioClientes.existeCliente(cliente)==false) {
				servicioClientes.guardarCliente(cliente);
				return "correcto";
			}
			else {
				return "DatosExistentes";
			}
		}*/
		
			
		
		
		
		
		
		
	}
	
	

	
