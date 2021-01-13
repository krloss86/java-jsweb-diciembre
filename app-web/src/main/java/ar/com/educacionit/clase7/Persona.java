package ar.com.educacionit.clase7;

public class Persona implements Comparable<Persona>{

	private Integer edad;
	private String nombre;

	public Persona(Integer edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Persona otraPersona) {				
		return otraPersona.edad.compareTo(this.edad);
	}

	@Override
	public String toString() {
		return "Persona [edad=" + edad + ", nombre=" + nombre + "]";
	}
	
	
}
