package ar.com.educacionit.clase2;

public class MainAuto {

	public static void main(String[] args) {
		//f6
		Auto clioRojo = new Auto("rojo", 123456,10);
		//f5
		clioRojo.arrancar();
		
		clioRojo.cargarCombistible(5);
		
		while(clioRojo.puedaAcelerar()) {
			clioRojo.acelerar(5);	
			clioRojo.frenar();
			clioRojo.acelerar();
		}
		
		//f8	
		System.out.println(clioRojo.getVelocidadActual());
		
		clioRojo.apagar();
	}

}
