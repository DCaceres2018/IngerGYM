package com.example.ej1spring;

public class Cliente {

	private String usuario;
	private String email;
	private String edad;
	private String nTelefono;
	
	Cliente(String usuario,String email,String edad, String nTelefono){
		this.usuario= usuario;
		this.email=email;
		this.edad=edad;
		this.nTelefono= nTelefono;
	
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getnTelefono() {
		return nTelefono;
	}

	public void setnTelefono(String nTelefono) {
		this.nTelefono = nTelefono;
	}
	
	
}
