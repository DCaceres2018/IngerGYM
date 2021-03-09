package IngerGYM.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	private String usuario;
	private String email;
	private boolean situacionLaboral;
	private int edad;
	private String nTelefono;
	private String contrasena;
	private int precio;
	
	@OneToMany
	private List<Clases> clases;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Cliente() {
		
	}
	
	public Cliente(String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo){
		super();
		this.usuario= usuario;
		this.situacionLaboral=trabajo;
		this.email=email;
		this.edad=edad;
		this.nTelefono= nTelefono;
		this.contrasena= contrasena;
		
		
		if(edad<18) {
			this.precio=15;
		}
		else if(edad>65) {
			this.precio=10;
		}
		else {
			
			if(trabajo==false) {
				this.precio=18;
			}
			else {
				this.precio=25;
			}
		}
	}
	public void setClass(Clases clase) {
		clases.add(clase);
	}
	public List<Clases> getListaClases(){
		return this.clases;
	}
	
	/*public void setOpinion(Opinion opinion) {
		this.opinion=opinion;
	}*/
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getnTelefono() {
		return nTelefono;
	}

	public void setnTelefono(String nTelefono) {
		this.nTelefono = nTelefono;
	}
	
	@Override
	public String toString() {
		return "Cliente [tlf="  + ", name=" + "usuario ]";
	}
}