package IngerGYM;

import java.util.List;

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
	public String guardarOpinion(@RequestParam String usuario,@RequestParam String texto){

		Opinion opinion= new Opinion (usuario,texto);
		
		if(servicioOpiniones.existeOpinion(opinion)==true) {
			return "ErrorOpinion";
		}
		
		return "opinionEnviada";
		
	}
	
	@PostMapping("/enviarOpinion")
	public String enviarOpinion(Model model){
		
		List<Opinion> opiniones = servicioOpiniones.getOpiniones();
		
		model.addAttribute("opinionesDisponibles",opiniones);
		
		return "enviarOpinion";
		
	}
}
