package IngerGYM.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import IngerGYM.entidades.Cliente;
import IngerGYM.repositorios.RepositorioClientes;


@Service
public class ServicioClientes {

	@Autowired
	private RepositorioClientes clientes;

	public Cliente findByUser(String nombr) {

		return clientes.findByUser(nombr);
		
	}

	public void saveClient(Cliente cliente) {
		
		this.clientes.save(cliente);
	}

	public void deleteClient(Cliente cliente) {
		
		this.clientes.delete(cliente);		
	}
}