package IngerGYM.servicios;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Opinion;
import IngerGYM.repositorios.*;

@Service
public class ServicioClases {
	
	@Autowired
	private RepositorioClases repositorioClases;
	
	
	public List<Clases> findAll(){
		return repositorioClases.findAll();
	}
	
	public Clases findById(long id){
		return repositorioClases.findById(id);
	}
	
	public void save(Clases clase) {
		repositorioClases.save(clase);
	}
	
	public void deleteById(long id) {
		repositorioClases.deleteById(id);
	}

	
}
