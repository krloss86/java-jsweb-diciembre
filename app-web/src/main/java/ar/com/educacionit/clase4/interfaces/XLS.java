package ar.com.educacionit.clase4.interfaces;

public class XLS extends ArchivoBase implements Exportable {

	public XLS(String nombre) {
		super(nombre);
	}

	@Override
	public void exportar() {
		System.out.println("Exportando " + getNombre() + " a XLS");		
	}

}
