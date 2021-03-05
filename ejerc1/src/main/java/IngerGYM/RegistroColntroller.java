package IngerGYM;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.repositorios.RepositorioClases;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.repositorios.RepositorioSalas;
import IngerGYM.entidades.*;

@Controller
public class RegistroColntroller {

	@Autowired
	private RepositorioClientes repositorioC;
	
	@Autowired
	private RepositorioClases repositorioCl;
	
	@Autowired
	private RepositorioSalas repositorioS;
	
	@PostConstruct
	public void init() {
		//String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo
		Cliente paco=new Cliente("paco","paco@gmail.com",54,"434343","abcd",true);
		repositorioC.save(paco);
		
		Salas piscina=new Salas("Piscina",20);
		repositorioS.save(piscina);
		
		//public Clases (String prof,String tipo,int dia, int hora)
		Clases AquaGym=new Clases("Maria","AquaGYM",3,7);
		repositorioCl.save(AquaGym);
		
	}
	
	
	@PostMapping("/registrarse")
	public String registrarse(@RequestParam nombre)
	{
		
		
		return "correcto";
	}
	
	
}
