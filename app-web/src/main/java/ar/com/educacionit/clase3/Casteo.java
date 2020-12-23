package ar.com.educacionit.clase3;

public class Casteo {

	public static void main(String[] args) {
		
		// byte < short < int < long < float < double
		
		double altura = 175.26;
		
		//widening casting, perdida de datos!!!
		
		float alturaF = (float)altura;
		
		long alturaL = (long)alturaF;
		
		int alturaI = (int)alturaL;
		
		short alturaS = (short)alturaI;
		
		byte aluraB = (byte) alturaS;
	}

}
