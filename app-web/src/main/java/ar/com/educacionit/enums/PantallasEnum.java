package ar.com.educacionit.enums;

public enum PantallasEnum {

	LISTADO("listado");	
	
	private String pantalla;
	
	private PantallasEnum(String pantalla) {
		this.pantalla = pantalla;
	}
	
	public String getPantalla() {
		return this.pantalla;
	}
}
