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

	private boolean usuarioNoExiste=false;
	private Cliente cliente;

	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/bienvenidos")
	public String registrarse(Model model,@RequestParam String nombre,@RequestParam String contraseña, HttpSession sesion){
		
		int resultado=servicioClientes.clienteCorrecto(nombre,contraseña);
		int numero= servicioClientes.posCliente(nombre);
		if(numero!=-1) {
			sesion.setAttribute("usuarioActual", nombre);
			this.cliente =servicioClientes.getCliente(numero);
		}
		 if(resultado==0) {
			 
			return "errorUsuario";
			
		}else if(resultado==1) {
			
			
			return "bienvenido";
			
		}
		
		return "incorrecto";
		
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
