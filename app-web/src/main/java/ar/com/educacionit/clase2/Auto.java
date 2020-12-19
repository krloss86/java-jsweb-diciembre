package ar.com.educacionit.clase2;

public class Auto {

	//atributos
	private int anio;
	private String color;
	private long chasis;
	private String patente;
	
	private boolean encendido;
	private float velocidadActual;
	private float velocidadMaxima; 
	private float combustible;
	
	//defecto
	Auto() {
		this.velocidadMaxima = 10;
	}
	
	//contructor
	Auto(String color, long chasis, float velocidadMaxima) {
		this.color = color;
		this.chasis = chasis;
		this.velocidadActual = 0;
		this.velocidadMaxima = velocidadMaxima;
	}
	
	Auto(String color, long chasis) {
		this.color = color;
		this.chasis = chasis;
	}
	
	//metodos
	void patentar(String nuevaPatente) {
		this.patente = nuevaPatente;
		System.out.println("Se ha patentado el auto");
	}
	
	void arrancar() {
		if(!this.encendido) {
			this.encendido = true;
		}else {
			System.out.println("El auto ya está encendido!");
		}
	}
	
	boolean isEncendido() {
		return this.encendido;
	}
	boolean hayCombustible() {
		return this.combustible > 0;
	}
	
	void acelerar() {
		if(this.isEncendido() && this.hayCombustible()) {
			if(this.velocidadActual < this.velocidadMaxima) {
				//incrementar la velocidad del auto
				this.velocidadActual++;
				this.combustible --;
			}else {
				System.out.println("Velocidad Máxima, no puede acelerar");
			}
		}else {
			System.out.println("Auto apagago, no puede acelerar");
		}
	}
	
	public void acelerar(float fuerza) {
		if(this.isEncendido() && this.hayCombustible()) {
			if((this.velocidadActual + fuerza) < this.velocidadMaxima) {
				//incrementar la velocidad del auto
				this.velocidadActual += fuerza;
				this.combustible -=3 ;
			}else {
				System.out.println("Velocidad Máxima, no puede acelerar");
			}
		}else {
			System.out.println("Auto apagago, no puede acelerar");
		}
	}
	
	void frenar() {
		if(this.encendido) {
			if(this.velocidadActual > 0) {
				this.velocidadActual --;
			}else {
				System.out.println("El auto se ha detenido");
			}
		}else {
			System.out.println("Auto apagago, no puede frenar");
		}
	}
	
	void apagar() {
		if(this.encendido) {
			this.velocidadActual = 0;
			this.encendido = false;
		}else {
			System.out.println("El auto ya está apgado!");
		}
	}
	
	boolean puedaAcelerar() {
		boolean puedeAcelerar = false;
		if(this.isEncendido() && this.hayCombustible()) {
			puedeAcelerar = this.velocidadActual < this.velocidadMaxima;
		}
		return puedeAcelerar;
	}
	
	void cargarCombistible(float litros) {
		this.combustible += litros;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getChasis() {
		return chasis;
	}

	public void setChasis(long chasis) {
		this.chasis = chasis;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public float getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(float velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(float velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public float getCombustible() {
		return combustible;
	}

	public void setCombustible(float combustible) {
		this.combustible = combustible;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	
	//alt+shit+s
	
}
