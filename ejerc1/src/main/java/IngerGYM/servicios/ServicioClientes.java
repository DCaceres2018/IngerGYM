package IngerGYM.servicios;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import IngerGYM.entidades.Cliente;
import IngerGYM.repositorios.RepositorioClientes;


@Service
public class ServicioClientes {

	private Cliente cliente;
	
	@Autowired
	private RepositorioClientes repositorio;


	@PostConstruct
	public void init() {
		
		//String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo
		Cliente paco=new Cliente("paco","paco@gmail.com",54,"434343","abcd",true);
		repositorio.save(paco);
		
		/*Salas piscina=new Salas("Piscina",20);
		repositorioS.save(piscina);
		
		//public Clases (String prof,String tipo,int dia, int hora)
		Clases AquaGym=new Clases("Maria","AquaGYM",3,7);
		repositorioCl.save(AquaGym);*/
	}
	public Collection<Cliente> getUsuarios() {
		return repositorio.findAll();
	}
		
	
	public void guardarCliente(Cliente cl) {
		repositorio.save(cl);
	}
	

	/*public Cliente getCliente(String nombre) {
		List Cliente=repositorio.findAll();
		for(int i=0;i<Cliente.size();i++) {
			Cliente prueba=(IngerGYM.entidades.Cliente) Cliente.get(i);
			
			
		}
			
		//return repositorio.findByName(nombre);
	}*/



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean existeCliente(String nombre) {
		List <Cliente> cliente1=repositorio.findAll();
		for(int i=0;i<cliente1.size();i++) {
			
			String ada=cliente1.get(i).getUsuario();
			if(ada.equals(nombre)) {
				return true;
			}
			
		}
		return false;
	}

	
}