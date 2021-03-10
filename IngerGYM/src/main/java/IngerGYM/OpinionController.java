package IngerGYM;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.entidades.*;

@Controller
public class OpinionController {


	@Autowired
	private ServicioClientes servicioCliente;
	
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	
	@GetMapping("/opiniones/{id}/opinionEnviada")
	public String enviarOpinion(Model model,HttpSession sesion,String opinion,@PathVariable long id) {
		
		Opinion opinionObjeto= new Opinion(opinion);
		
		opinionObjeto.setCliente(servicioCliente.findById(id));
		servicioOpiniones.save(opinionObjeto);
		
		return "opinionEnviada";
	
	}
	
	@GetMapping("/opiniones/{id}")
	public String verOpiniones(Model model,@PathVariable long id){
		
		
		List<Opinion> opiniones = servicioOpiniones.findAll();
		model.addAttribute("opinionesDisponibles",opiniones);
		return "opiniones";
	}
}
