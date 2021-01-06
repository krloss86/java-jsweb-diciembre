package ar.com.educacionit.clase5.exceptions;

public class OperacionMetamatica {

	//si b es 0, lanzo una exception
	public float dividir(float a, float b) throws MiException{
		
		if(b == 0) {
			throw new MiException();
		}
		
		return a / b;
	}
}
