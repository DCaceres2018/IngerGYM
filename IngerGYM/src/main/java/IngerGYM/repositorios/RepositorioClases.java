package IngerGYM.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Tarifa;

@Repository
public interface RepositorioClases extends JpaRepository<Clases, Long> {
	
	
	Clases findById(long id);
}