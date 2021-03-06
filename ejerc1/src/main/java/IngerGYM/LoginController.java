package IngerGYM;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.entidades.*;

@Controller
public class LoginController {


	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/bienvenidos")
	public String registrarse(@RequestParam String nombre,@RequestParam String contraseña){
		
		int resultado=servicioClientes.clienteCorrecto(nombre,contraseña);
		
		 if(resultado==0) {
			return "incorrecto";
		}else if(resultado==1) {
			return "bienvenido";
		}
		
		return "incorrecto";
		
	}
}
