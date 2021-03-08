package IngerGYM.servicios;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IngerGYM.entidades.Opinion;
import IngerGYM.repositorios.RepositorioOpiniones;

import java.util.List;
@Service
public class ServicioOpiniones {

	
	@Autowired
	private RepositorioOpiniones repositorioOpiniones;
	
	@PostConstruct
	public void init() {
		
		Opinion carlos=new Opinion("carlos","vaya tio vayyaaa");
		repositorioOpiniones.save(carlos);
	}
	
	//Comprobamos si ya ha realizado una opinion, si no la ha realizado se guarda y encontrado= false; en caso contrario encontrado = true
	public boolean existeOpinion(Opinion opinion) {
		
		
		List<Opinion> listaOpiniones = repositorioOpiniones.findAll();
		boolean encontrado=false;
		
		for(Opinion opiniones: listaOpiniones) {
			if( opiniones.getNombre().equals(opinion.getNombre())) {
				encontrado=true;
				break;
			}
	}
		
		if(encontrado==false) {
			repositorioOpiniones.save(opinion);
		}
		return encontrado;
	}
	
	public List<Opinion> getOpiniones(){
		
		return repositorioOpiniones.findAll();
	}
	
}
