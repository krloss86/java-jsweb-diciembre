package ar.com.educacionit.clase13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MainLambda {

	public static void main(String[] args) {
		
		Collection<Integer> edades = new ArrayList<Integer>();
		edades.add(25);		
		edades.add(35);		
		edades.add(40);		
		edades.add(21);

		//edad > 21 && pares
		//QUE COMO,
		Integer contador = 0;
		for(Integer edad : edades) {
			contador += edad;
		}
		
		System.out.println(contador);
		
		//expresiones lambda QUE HACER Y NO COMO HACER
		Integer contadorj8 = edades.stream()
				.reduce(0, (x,y) -> x + y);
		
		System.out.println(contadorj8);
	}

}
