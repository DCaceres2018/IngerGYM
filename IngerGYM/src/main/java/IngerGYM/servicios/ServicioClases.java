package IngerGYM.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IngerGYM.entidades.Clases;
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
