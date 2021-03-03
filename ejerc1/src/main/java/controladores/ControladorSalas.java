package controladores;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entidades.*;
import repositorios.*;

@RestController
public class ControladorSalas {

	@Autowired
	private RepositorioSalas RepositorioSalas;
	
	@Autowired
	private RepositorioClientes RepositorioCliente;

	@PostConstruct
	public void init() {

		Salas s1 = new Salas("piscina", 20);
		
		RepositorioSalas.save(s1);
		
		Cliente c1 = new Cliente("Torres", "torres@gmail.com",20,"6447377","123",false);
		Cliente c2 = new Cliente("Torres2", "torres2@gmail.com",20,"64473772","1233",true);
		
		c1.setSala(s1);
		c2.setSala(s1);
		
		RepositorioCliente.save(c1);
		RepositorioCliente.save(c2);
		
	}

	@GetMapping("/clientes/")
	public List<Salas> getTeams() throws Exception {
		return RepositorioSalas.findAll();
	}
	
}
