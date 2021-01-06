package ar.com.educacionit.clase5.exceptions;

public class MainClase5 {

	public static void main(String[] args) {
		//TIEMPO DE COMPILACION!!!
		
		ClaseBase clase1 = new Clase1();

		ClaseBase clase2 = new Clase2();
		
		clase1.metodo1();
		
		clase2.metodo1();
		
		Ejecutable ejecuableClase1 = (Ejecutable)clase1;
		ejecuableClase1.execute();
		
		Ejecutable ejecuableClase2 = (Ejecutable)clase2;
		ejecuableClase2.execute();
		
	}

}
