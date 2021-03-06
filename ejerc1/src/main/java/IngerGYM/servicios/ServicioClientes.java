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

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.Salas;
import IngerGYM.repositorios.RepositorioClases;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.repositorios.RepositorioSalas;


@Service
public class ServicioClientes {

	private Cliente cliente;
	
	@Autowired
	private RepositorioClientes repositorioClientes;

	@Autowired
	private RepositorioSalas repositorioS;
	@Autowired
	private RepositorioClases repositorioCl;
	
	@PostConstruct
	public void init() {
		/*
		
		//String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo
		Cliente paco=new Cliente("paco","paco@gmail.com",54,"434343","abcd",true);
		repositorioClientes.save(paco);
		Salas piscina=new Salas("Piscina",20);
		repositorioS.save(piscina);
		
		Salas gimnasio=new Salas("Gym",40);
		repositorioS.save(gimnasio);
		
		Salas comun=new Salas("Zumba",50);
		repositorioS.save(comun);
		
		//public Clases (Salas sala,String prof,String tipo,int dia, int hora)
		Clases AquaGymMiercoles=new Clases(piscina,"Maria","AquaGYM",3,7);
		repositorioCl.save(AquaGymMiercoles);
		Clases NadoLibre=new Clases(piscina,"Juan","NadoLibre",5,2);
		repositorioCl.save(NadoLibre);
		Clases Zumba=new Clases(comun,"Aitor","Zumba",1,8);
		repositorioCl.save(Zumba);
		*/
	}

	
	public Collection<Cliente> getUsuarios() {
		return repositorioClientes.findAll();
	}
		
	
	public void guardarCliente(Cliente cl) {
		repositorioClientes.save(cl);
	}
	

	public int posCliente(String nombre) {
		List <Cliente> listaClientes=repositorioClientes.findAll();
		for(int i=0;i<listaClientes.size();i++) {
			
			Cliente prueba=listaClientes.get(i);
			if(prueba.getUsuario().equals(nombre)) {
				return i;
			}
			
			
		}
		return -1;
			
		//return repositorio.findByName(nombre);
	}
	
	public Cliente getCliente(int numero) {
		List <Cliente> listaClientes=repositorioClientes.findAll();
		return listaClientes.get(numero);
			
		//return repositorio.findByName(nombre);
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean existeCliente(String usuario,String email) {
		
		List <Cliente> listaClientes=repositorioClientes.findAll();
		boolean encontrado=false;
		for(Cliente cliente : listaClientes) {
			
			if(cliente.getUsuario().equals(usuario) ||cliente.getEmail().equals(email)  ) {
				encontrado = true;
				break;
			}
		}
		
		return encontrado;
	}
	
	public int clienteCorrecto(String usuario,String contrasena) {
		
		List <Cliente> listaClientes=repositorioClientes.findAll();
		int encontrado=-1;
		
		//Si = 0 usuario correcto 
		//Si =1 usuario y contraseña correcto
		for(Cliente cliente : listaClientes) {
			
			if(cliente.getUsuario().equals(usuario) ) {
				encontrado = 0;
				if(cliente.getContrasena().equals(contrasena) ) {
					encontrado = 1;
				}
				break;
			}
		}
		
		return encontrado;
	}

	
}