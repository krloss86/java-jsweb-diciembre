package ar.com.educacionit.clase5.exceptions;

public class MainPersona {

	public static void main(String[] args) {
		
		Persona persona = new Persona("manuel");
		persona.caminar();
		
		//matar el objeto!	
		persona = null;
		
		//null solo se puede usar con objetos!!!
		
		Persona persona2 = null;
		persona2.caminar();

		System.out.println("continuamos...");
	}

}
