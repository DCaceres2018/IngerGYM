package IngerGYM.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.ContadorAforo;
import IngerGYM.entidades.Opinion;
import IngerGYM.entidades.Salas;
import IngerGYM.entidades.Tarifa;
import IngerGYM.repositorios.RepositorioOpiniones;
import IngerGYM.repositorios.RepositorioTarifa;

import java.util.List;

import javax.annotation.PostConstruct;


@Service
public class ServicioTarifas {

	@Autowired
	private RepositorioTarifa repositorioTarifa;
	
	@PostConstruct
	public void init() {
		
		Tarifa tarifa1=new Tarifa(1);
		Tarifa tarifa2=new Tarifa(27);
		Tarifa tarifa3=new Tarifa(67);
		
		Cliente cliente= new Cliente("andres","paco@gmail.com",54,"abcd");
		repositorioTarifa.save(tarifa2);
		repositorioTarifa.save(tarifa1);
		repositorioTarifa.save(tarifa3);
	}
	
	public List<Tarifa> findAll(){
		return repositorioTarifa.findAll();
	}
	
	public Tarifa findById(long id){
		return repositorioTarifa.findById(id);
	}
	
	public void save(Tarifa tarifa) {
		repositorioTarifa.save(tarifa);
	}
	
	public void deleteById(long id) {
		
		repositorioTarifa.deleteById(id);
	}
	
}
