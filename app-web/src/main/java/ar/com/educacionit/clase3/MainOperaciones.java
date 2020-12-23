package ar.com.educacionit.clase3;

import java.util.Scanner;

public class MainOperaciones {

	public static void main(String[] args) {
		
		int var1;
		int var2;
		String op;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("var1");
		var1 = teclado.nextInt();
		
		System.out.println("var2");
		var2 = teclado.nextInt();
		
		System.out.println("op");
		op = teclado.next();
		
		Operaciones calculadora = new Operaciones(var1, var2, op);
		
		float res = calculadora.calcular();
		

	}

}
