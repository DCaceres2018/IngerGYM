package IngerGYM;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.entidades.*;

@Controller
public class RegistroController {

	@Autowired
	private ServicioClientes servicioClientes;
	
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	
	
	@PostMapping("/registro")
	public String registrarse(Cliente usuario)
	{
		
		/*Cliente cliente=new Cliente("carlos","email",5,"123");
		Cliente cliente1=new Cliente("jositote","email",5,"123");
		Opinion opinion= new Opinion("devil que hase",cliente);*/
		
		
		servicioClientes.save(usuario);
		/*servicioClientes.save(cliente);
		servicioClientes.save(cliente1);*/
		
		
		//servicioOpiniones.save(opinion);
		
		return "usuarioRegistrado";
	}
}

		
	

	

	
