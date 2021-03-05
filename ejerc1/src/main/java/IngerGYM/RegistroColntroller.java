package IngerGYM;

import java.util.List;

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
	public String registrarse(@RequestParam String Usuario,@RequestParam String Email,@RequestParam int edad,@RequestParam String nTelefono,@RequestParam String Contraseña)
	{
		if(Usuario==""||Email=="") {
			return "incorrecto";
		}
		else {
			List<Cliente> nombres = repositorioC.findByUser(Usuario);
			int i=0;
			for(Cliente nombre:nombres) {
				i++;
			}
			List<Cliente> emails = repositorioC.findByUser(Email);
			int j=0;
			for(Cliente email:emails) {
				j++;
			}
			
			if(i>0||j>0) {
				return "DatosExistentes";
			}
			else {
				boolean si=true;
				//crear usuario
				Cliente nuevo=new Cliente(Usuario,Email,edad,nTelefono,Contraseña,si);
				repositorioC.save(nuevo);
				return "correcto";
			}
		}
		
		
	}
	
	
}
