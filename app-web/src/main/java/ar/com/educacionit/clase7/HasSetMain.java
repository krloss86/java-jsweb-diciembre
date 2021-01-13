package ar.com.educacionit.clase7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class HasSetMain {

	public static void main(String[] args) {
		
		//db!
		
		Scanner teclado = new Scanner(System.in);
		
		Collection<Persona> personas = new TreeSet<>();
		String continuar;
		do {
			System.out.print("Edad: ");
			Integer edad = teclado.nextInt();
			
			System.out.print("Nombre: ");
			String nombre = teclado.next();
			
			Persona persona = new Persona(edad, nombre);
			
			personas.add(persona);
			
			System.out.print("Continuar: S/N");
			continuar = teclado.next();
			
		}while("S".equals(continuar)) ;

		System.out.println(personas);
		
		System.out.println("Indique el orden: 1 - Edad Asc"); 
		System.out.println("Indique el orden: 2 - Edad Desc");
		System.out.println("Indique el orden: 3 - Nombre Asc");
		System.out.println("Indique el orden: 4 - Nombre Desc");
		
		Integer opcion = teclado.nextInt();
		
		Comparator<Persona> comparador = new PersonaEdadCompartator(opcion);
				
		List<Persona> personasList =  new ArrayList<>(personas);
		
		Collections.sort(personasList, comparador);
	
		System.out.println(personasList);
		teclado.close();
	}

}


