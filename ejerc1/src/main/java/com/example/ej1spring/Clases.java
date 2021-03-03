package com.example.ej1spring;

public class Clases {

	private String profesor;
	private String tipo; 
	private Salas sala;
	private int dia;
	private int hora;
	
	public Clases (Salas sala,String prof,String tipo,int dia, int hora) {
		
		this.sala=sala;
		if(sala.compHora(dia, hora)==true) {
			sala.cogerHora(dia, hora);
			this.profesor=prof;
			this.tipo=tipo;
			this.dia=dia;
			this.hora=hora;
		}
		
	
	}
	public int [] queclase(){
		int i[]=new int [1];
		i[1]=hora;
		i[0]=dia;
		return i;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Salas getSala() {
		return sala;
	}

	public void setSala(Salas sala) {
		this.sala = sala;
	}
}
