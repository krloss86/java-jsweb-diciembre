package ar.com.educacionit.clase7;

import java.util.Comparator;

/**
 * Ordena personas por nombre asc
 * @author CX PC
 *
 */
public class PersonaNombreAsc implements Comparator<Persona>{

	public int compare(Persona persona1, Persona persona2) {
		
		/*int a = 10;
		int b = 11;
		a - b < 0 => ASC
	    b - a > 0 => DESC*/
		//
		return persona1.getNombre().compareTo(persona2.getNombre());
	}

}
