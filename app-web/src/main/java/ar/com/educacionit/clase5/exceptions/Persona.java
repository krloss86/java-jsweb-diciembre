package ar.com.educacionit.clase5.exceptions;

public class Persona {

	String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public void caminar() {
		System.out.println(this.nombre + " caminando");
	}

}
