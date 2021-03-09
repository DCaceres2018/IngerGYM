package IngerGYM;



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
	
	@PostMapping("/registrarse")
	public String registrarse(Cliente usuario)
	{
		
		if(servicioClientes.existeCliente(usuario.getUsuario())==-1) {
			
			servicioClientes.guardarCliente(usuario);
			return "correcto";
		}else {
			return "DatosExistentes";
			}
	}
}

		
	

	
