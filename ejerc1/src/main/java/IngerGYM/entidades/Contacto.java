package IngerGYM.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private String numero;
	private String email;
	
	public Contacto() {
		this.email="IngerGYM@gmail.com";
		this.numero="63333__1";
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
