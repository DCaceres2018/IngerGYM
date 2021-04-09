package IngerGYM.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import IngerGYM.entidades.Clases;

@Repository
public interface RepositorioClases extends JpaRepository<Clases, Long> {
	
	Clases findById(long id);
}