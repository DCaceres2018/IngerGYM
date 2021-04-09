package IngerGYM.entidades;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class ComponenteCliente {

	private Cliente user;

	public Cliente getLoggedUser() {
		return user;
	}

	public void setLoggedUser(Cliente user) {
		this.user = user;
	}

	public boolean isLoggedUser() {
		return this.user != null;
	}

}

