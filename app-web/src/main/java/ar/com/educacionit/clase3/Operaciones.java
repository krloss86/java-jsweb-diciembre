package ar.com.educacionit.clase3;

public class Operaciones {

	private int var1;
	private int var2;
	private String op;

	public Operaciones(int var1, int var2, String operacion) {
		this.var1 = var1;
		this.var2 = var2;
	}
	
	float calcular()  {
	
		float res = -1;
		
		switch (this.op) {
			case "+":
				res = this.var1 + this.var2;
				break;	
			case "-":
				res = this.var1 - this.var2;
				break;
			default:
				System.err.println("Operacion inválida");
		}
		
		return res; 
	}
	
	
}
