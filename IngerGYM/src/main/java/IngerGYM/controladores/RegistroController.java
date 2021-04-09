package IngerGYM.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.servicios.ServicioClientes;
import IngerGYM.entidades.*;

@Controller
public class RegistroController {

	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/registro")
	public String registrarse(@RequestParam String name,@RequestParam String email,@RequestParam int edad,@RequestParam String passwordHash){
		
		Cliente cliente= new Cliente(name,email,edad,passwordHash,"ROLE_USER");
		
		//Comprobamos si ya existe en la base de datos
		if(servicioClientes.findByNombre(cliente.getName()) != null) {
			return ("/errorRegistro");
	
		}else {
			
			servicioClientes.save(cliente);
			return "usuarioRegistrado";	
			
		}
	}
}


