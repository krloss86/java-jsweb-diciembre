package ar.com.educacionit.clase3;

public class Humano {

	//#
	protected String nombre;
	protected String apellido;
	protected String nacionalidad;
	
	//si una clase tiene un constructor que no es por defecto
	//entonces las clases hijas deberan implementar minimamente ese dicho constructor
	
	//contructor, parametrizado
	public Humano(String nombre, String apellido, String nacionalidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
	}

	//alt+shit+s
	/**
	 * @param nombre
	 * @param apellido
	 */
	public Humano(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	private void ladrar() {
		//syso+ctrl+space
		System.out.println("Un humano ladrando");
	}
	
	public void caminiar() {
		System.out.println("Canina el humano!!!");
	}
	
	protected void cantar() {
		System.out.println("Canta el humano!!!");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
}
