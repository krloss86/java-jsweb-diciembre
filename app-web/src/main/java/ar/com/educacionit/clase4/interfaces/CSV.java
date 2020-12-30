package ar.com.educacionit.clase4.interfaces;

public class CSV extends ArchivoBase implements Exportable {

	public CSV(String nombre) {
		super(nombre);
	}

	@Override
	public void exportar() {
		System.out.println("Exportando " + getNombre() + " a CSV");		
	}

}
