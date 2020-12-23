package ar.com.educacionit.clase3;

public class Hombre extends Humano {

	public static boolean nuez = true;
	
	private boolean futbolero;
	
	public Hombre(String nombre, String apellido) {
		super(nombre, apellido);
	}

	//get/set
	public boolean isFutbolero() {
		return this.futbolero;
	}

	public void setFutbolero(boolean futbolero) {
		this.futbolero = futbolero;
	}

	
	@Override
	protected void cantar() {
		//Hago lo del humano
		super.cantar();
		//mas
		System.out.println(this.nombre + "," + this.apellido + " tambien canta");
	}
}
