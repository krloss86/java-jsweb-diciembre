package ar.com.educacionit.clase7;

import java.util.Comparator;

/**
 * Ordena personas por nombre asc
 * @author CX PC
 *
 */
public class PersonaEdadCompartator implements Comparator<Persona>{

	private Integer orden;
	
	public PersonaEdadCompartator(Integer orden) {
		this.orden = orden;
	}

	public int compare(Persona persona1, Persona persona2) {
		
		/*int a = 10;
		int b = 11;
		a - b < 0 => ASC
	    b - a > 0 => DESC*/
		//
		switch (orden) {
			case 1:
				return persona1.getEdad().compareTo(persona2.getEdad());
			case 2:
				return persona2.getEdad().compareTo(persona1.getEdad());
			case 3:
				return persona1.getNombre().compareTo(persona2.getNombre());
			case 4:
				return persona2.getNombre().compareTo(persona1.getNombre());
			default:
				return 0;
			}
	}

}
