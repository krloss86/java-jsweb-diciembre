package ar.com.educacionit.clase2;

public class Persona {

	//atributos de clase
	static int cantidadOjos = 2;
	
	//atributos de instancia
	private String nombre; //ocultando el atributo
	String apellido;
	int tipoDocumento;
	String numeroDocumento;
	int edad;
	
	//contructor por defecto
	Persona() { 
		
	}
	
	//alt+shit+s
	public Persona(String nombre, String apellido, int tipoDocumento, String numeroDocumento, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.edad = edad;
	}	
	
	//metodos
	String saludar() {
		//logica 
		String saludo = "hola soy " + this.nombre + " mucho gusto!";
		return saludo;
	}
	
	//sobrecarga de saludar
	public String saludar(boolean gritar) {
		String saludo;
		if(!gritar) {
			saludo = this.saludar();
		}else {
			saludo = "HOLA SOY " + this.nombre + " " + this.apellido + " MUCHO GUSTO!";	
		}
		return saludo;
	}
	
	void informar() {
		if(edad > 18) {
			System.out.println("Soy " + this.nombre + " "+ this.apellido +", soy mayor de edad" );
		}else {
			System.out.println("Soy " + this.nombre + " "+ this.apellido +", soy menor de edad" );
		}
	}
	
	//exponiendo un metodo para poder cambiar el nombre
	public void cambiarNombre(String nuevoNombre) {
		if(nuevoNombre !=null) {			
			this.nombre = nuevoNombre.toUpperCase();
		}else {
			System.err.println("Nombre inválido");
		}
	}
	
	public String getNombre() {
		return this.nombre.toUpperCase();
	}
}
