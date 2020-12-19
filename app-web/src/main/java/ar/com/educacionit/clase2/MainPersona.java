package ar.com.educacionit.clase2;

public class MainPersona {

	public static void main(String[] args) {
		
		//creo un objeto de la clase persona usando el contructor por defecto (sin argumentos)
		Persona carlos = new Persona("Carlos","Lopez",1, "31112244",78);
		Persona ana = new Persona("Ana","Manera",1,"30123456",17);
		System.out.println(ana.saludar(true));
		
		//ana.nombre  = "carla";
		ana.cambiarNombre("carla");
		System.out.println(ana.saludar());
		
		//ejecutar/invocar un metodo del objeto carlos
		String saludoDeCarlos = carlos.saludar();
		
		//mostrar el saludo de carlos por consola
		System.out.println(saludoDeCarlos);
		
		//invocar el atributo de clase cantidadDeOjos de la clase Persona
		System.out.println(carlos.getNombre() + " - tiene " + Persona.cantidadOjos + " ojos");
		carlos.informar();
		ana.informar();
		
		//invocar el atributo de instancia cantidadDeOjos del objeto carlos, de la clase Persona
		System.out.println(carlos.getNombre() + " - tiene " + carlos.cantidadOjos + " ojos");
	}

}
