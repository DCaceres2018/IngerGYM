package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Clases;


public interface RepositorioClases extends JpaRepository<Clases, Long> {
	
}