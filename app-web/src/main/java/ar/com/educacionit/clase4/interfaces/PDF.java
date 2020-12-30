package ar.com.educacionit.clase4.interfaces;

public class PDF extends ArchivoBase implements Exportable {

	public PDF(String nombre) {
		super(nombre);
	}

	@Override
	public void exportar() {
		System.out.println("Exportando " + getNombre() + " a PDF");		
	}

}
