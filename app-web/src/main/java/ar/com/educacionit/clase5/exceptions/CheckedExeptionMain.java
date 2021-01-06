package ar.com.educacionit.clase5.exceptions;

public class CheckedExeptionMain {

	public static void main(String[] args) {
		
		OperacionMetamatica om = new OperacionMetamatica();
		
		//una forma!
		try {
			
			float resultado = om.dividir(10, 0);
			
			System.out.println(resultado);
			
		}catch (MiException e) {
			e.printStackTrace();
		}
		
		System.out.println("continuo!! sin problemas");
	}

}
