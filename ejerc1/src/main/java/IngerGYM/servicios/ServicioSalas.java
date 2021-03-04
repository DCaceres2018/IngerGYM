package IngerGYM.servicios;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import IngerGYM.entidades.*;
import IngerGYM.repositorios.*;

@Service
public class ServicioSalas {
	
	@Autowired
	private RepositorioSalas RepositorioSalas;

	public Optional<Salas> buscarClase(long id) {

		return RepositorioSalas.findById(id);
		
	}
	
	public void anadirSala(Salas sala) {
		
		RepositorioSalas.save(sala);
	}

	public void eliminarSala(Salas sala){
		RepositorioSalas.delete(sala);
	}
	
}