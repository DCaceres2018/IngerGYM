package IngerGYM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.entidades.Cliente;
import IngerGYM.servicios.*;

@Controller

public class ReservaController {

	@Autowired
	private ServicioClientes servicioCliente;
	
	@PostMapping("/reservarPiscina")
	public String reservarPiscina(Model model,@RequestParam int dia,@RequestParam int hora){
		
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
	@PostMapping("/reservarZumba")
	public String reservarZumba()
	{
		int d=1;
		int h=8;
		
		boolean hay=servicioCliente.reservarZumba(d, h);
		if(hay==true) {
			return "ReservaRealizada";
		}
		else {
			return "AforoTope";
		}
		
	}
	@PostMapping("/reservarAquagym")
	public String reservarAquaGym()
	{
		int d=3;
		int h=7;
		
		boolean hay=servicioCliente.reservarAqua(d, h);
		if(hay==true) {
			return "ReservaRealizada";
		}
		else {
			return "AforoTope";
		}
		
	}
	@PostMapping("/reservarGimnasio")
	public String reservarGimnasio(@RequestParam int dia,@RequestParam int hora)
	{
		int d=dia;
		int h=hora-9;
		
		boolean hay=servicioCliente.reservarGimnasio(d, h);
		if(hay==true) {
			return "ReservaRealizada";
		}
		else {
			return "AforoTope";
		}
		
	}
}
