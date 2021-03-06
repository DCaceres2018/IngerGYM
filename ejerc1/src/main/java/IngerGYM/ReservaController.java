package IngerGYM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.entidades.Cliente;
import IngerGYM.servicios.*;

@Controller

public class ReservaController {

	@Autowired
	private ServicioClientes servicioCliente;
	
	@PostMapping("/reservarPiscina")
	public String reservarPiscina(@RequestParam int dia,@RequestParam int hora)
	{
		int d=dia;
		int h=hora-9;
		
		boolean hay=servicioCliente.reservarPiscina(d, h);
		if(hay==true) {
			return "ReservaRealizada";
		}
		else {
			return "AforoTope";
		}
		
	}
}
