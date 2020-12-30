package ar.com.educacionit.clase4.interfaces;

public abstract class ArchivoBase {

	protected String nombre;
	
	public ArchivoBase(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
