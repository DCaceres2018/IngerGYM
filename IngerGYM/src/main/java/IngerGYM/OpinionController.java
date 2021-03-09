package IngerGYM;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.entidades.*;

@Controller
public class OpinionController {


	@Autowired
	private ServicioOpiniones servicioOpiniones;
	
	@PostMapping("/opiniones")
	public String guardarOpinion(@RequestParam String texto, HttpSession sesion){
		
		//Creamos una opinión con el usaurio actual, si ya ha realiizado alguna opinion no podrá incluir otra
		
		/*String usuarioActual= (String)sesion.getAttribute("usuarioActual");
		Opinion opinion= new Opinion (texto);*/
		
		/*if(servicioOpiniones.existeOpinion(opinion)==true) {
			return "ErrorOpinion";
		}*/
		
		return "opinionEnviada";
		
	}
	
	@PostMapping("/enviarOpinion")
	public String enviarOpinion(Model model, HttpSession sesion){
		/*String usuarioActual= (String)sesion.getAttribute("usuarioActual");
		List<Opinion> opiniones = servicioOpiniones.getOpiniones();
		model.addAttribute("usuarioActual",usuarioActual);
		model.addAttribute("opinionesDisponibles",opiniones);*/
		
		return "enviarOpinion";
		
	}
}
