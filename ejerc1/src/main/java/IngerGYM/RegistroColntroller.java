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


	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/registrarse")
	public String registrarse(@RequestParam String usuario,@RequestParam String email,@RequestParam int edad,@RequestParam String nTelefono,@RequestParam String contraseña)
	{
		if(servicioClientes.existeCliente(usuario,email)==false) {
			Cliente cliente=new Cliente(usuario,email,edad,nTelefono,contraseña,true);
			servicioClientes.guardarCliente(cliente);
			return "correcto";
		}else {
			return "DatosExistentes";
			}
	}
}

		
	

	
