package IngerGYM;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.entidades.*;

@Controller
public class LoginController {

	private Cliente cliente;

	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/bienvenidos")
	public String registrarse(Model model,@RequestParam String nombre,@RequestParam String contraseña, HttpSession sesion){
		
		sesion.setAttribute("usuarioActual",nombre);
		
		int resultado=servicioClientes.existeCliente(nombre);
		
		if(resultado!=-1 ) {
			this.cliente =servicioClientes.getCliente(resultado);
			
			//Comprobamos la contraseña
			if(this.cliente.getContrasena().equals(contraseña)==false) {
				return "incorrecto";
			}
			//Si hemos llegado aqui, usuario y contraseña son correctos
			model.addAttribute("usuarioActual", nombre);
			return "bienvenidos";
			
		}else {
			
			return "incorrecto";
		}
	}
	
	@PostMapping("/tarifa")
	public String tarifa() {
		Cliente cl=this.cliente;
		if(cl.getEdad()<18) {
			return "tarifaNiños";
		}
		else if(cl.getEdad()>65) {
			return "tarifaAncianos";
		}
		else {
			return "tarifaAdultos";
		}
	}
	
}
