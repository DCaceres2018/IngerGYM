package IngerGYM.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.entidades.*;

@Controller
public class RegistroController {

	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/registro")
	public String registrarse(Cliente usuario){
		
		servicioClientes.save(usuario);

		return "usuarioRegistrado";
	}
}

		
	

	

	
