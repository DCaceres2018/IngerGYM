package IngerGYM.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.entidades.*;

@Controller
public class OpinionController {
	
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	@Autowired
	private ServicioClientes servicioClientes;
	
	@GetMapping("/opiniones/opinionEnviada")
	public String enviarOpinion(Model model,HttpSession sesion,String opinion) {
		
		Cliente cliente= (Cliente) sesion.getAttribute("usuarioActual");
		Opinion opinionObjeto= new Opinion(opinion);
		
		
		servicioOpiniones.save(opinionObjeto);
		opinionObjeto.setCliente(servicioClientes.findById(cliente.getId()));
		servicioOpiniones.save(opinionObjeto);
		return "opinionEnviada";
	
	}
	
	@GetMapping("/opiniones")
	public String verOpiniones(Model model){
		
		List<Opinion> opiniones = servicioOpiniones.findAll();
		model.addAttribute("opinionesDisponibles",opiniones);
		return "opiniones";
	}
}
