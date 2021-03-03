package com.example.ej1spring;

public class Cliente {

	private String usuario;
	private String email;
	private boolean situacionLaboral;
	private int edad;
	private String nTelefono;
	private String contrasena;
	private tarifa tarifa;
	private int precio;
	
	Cliente(String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo){
		this.usuario= usuario;
		this.situacionLaboral=trabajo;
		this.email=email;
		this.edad=edad;
		this.nTelefono= nTelefono;
		this.contrasena= nTelefono;
		this.precio=tarifa.tarifa(edad,trabajo);
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
	
	
}
