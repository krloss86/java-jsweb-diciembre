package ar.com.educacionit;

public class Clase1 {

	public static void main(String[] args) {
		
		// variables
		
		// numericas
		// byte < short < int < long < float < double 
		
		// boolean : true ó false
		// char 'a'
		
		//String nombre = "carlos";
		
		// operadores
		// ++ --  *= -=
		// logicos and &&; or ||; xor ^ ; nor !
		// aritmeticos + - * / ^
		// asignacion =
		// relacionales == != < >
		
		//estructuras if, for, while, do, while
		
		// 3 notas menor, mayor, pmin, pmay, promedio
		// suma de los menores, resta mayores
		// si suma menores es igual a la resta de los mayores
		
		int nota1;
		int nota2;
		int nota3;
		int menor = 0;
		int mayor = 0;
		int sumaMenores = 0;
		int restaMayores;
		boolean iguales;
		byte pMenor = 0;
		byte pMayor = 0;
		float promedio;
		
		nota1 = 5;
		nota2 = 8;
		nota3 = 9;
		
		//menor
		if ( (nota1 < nota2) & (nota1 < nota3) ) {
			menor = nota1;
			pMenor = 1;
		}
		if(nota2 < nota1 && nota2 < nota3) {
			menor = nota2;
			pMenor = 2;
		}
		if(nota3 < nota1 && nota3 < nota2) {
			menor = nota3;
			pMenor = 3;
		}
		
		//mayor
		if ( (nota1 >nota2) & (nota1 > nota3) ) {
			mayor = nota1;
			pMayor = 1;
		}
		if(nota2 > nota1 && nota2 > nota3) {
			mayor = nota2;
			pMayor = 2;
		}
		if(nota3 > nota1 && nota3 > nota2) {
			mayor = nota3;
			pMayor = 3;
		}
		
		//promedio
		promedio = nota1+nota2+nota3 / 3;
		sumaMenores = menor;
		restaMayores = mayor;
		
		//iguales
		iguales = (sumaMenores == restaMayores);
		
		System.err.println(menor);
		System.out.println(pMenor);
		System.err.println(mayor);
		System.out.println(pMayor);
		System.err.println(promedio);
		System.err.println(iguales);
	}

}
