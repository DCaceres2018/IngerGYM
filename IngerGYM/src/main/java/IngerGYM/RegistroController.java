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
	public String registrarse(@RequestParam String usuario,@RequestParam String email,@RequestParam int edad,@RequestParam String nTelefono,@RequestParam String contraseña)
	{
		if(usuario.equals("")) {
			return "errorRegistro";
		}
		if(email.equals("")) {
			return "errorRegistro";
		}
		if(nTelefono.equals("")) {
			return "errorRegistro";
		}
		
		if(servicioClientes.existeCliente(usuario,email)==-1) {
			Cliente cliente=new Cliente(usuario,email,edad,nTelefono,contraseña,true);
			servicioClientes.guardarCliente(cliente);
			return "correcto";
		}else {
			return "DatosExistentes";
			}
	}
}

		
	

	
