package ar.com.educacionit.clase5.exceptions;

public class CheckedExeptionMain2 {

	public static void main(String[] args) throws MiException{
		
		OperacionMetamatica om = new OperacionMetamatica();
		
		//otra forma!
		
		float resultado = om.dividir(10, 0);
		
		System.out.println(resultado);			
		
		System.out.println("continuo!! sin problemas");
	}

}
