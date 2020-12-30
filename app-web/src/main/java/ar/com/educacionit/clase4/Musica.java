package ar.com.educacionit.clase4;

import ar.com.educacionit.clase3.articulo.Articulo;

public class Musica extends Articulo {

	private String selloDiscografico ;
	private String[] listaTemas;
	
	public Musica(Long id, String titulo, String autor, Float precio, String selloDiscografico, String[] listaDeTemas) {
		//llama al padre!
		super(id, titulo, autor, precio);
		
		//seteo los propios
		this.selloDiscografico = selloDiscografico;
		this.listaTemas = listaDeTemas;
	}

	public String getSelloDiscografico() {
		return selloDiscografico;
	}

	public void setSelloDiscografico(String selloDiscografico) {
		this.selloDiscografico = selloDiscografico;
	}

	public String[] getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(String[] listaTemas) {
		this.listaTemas = listaTemas;
	}

}
