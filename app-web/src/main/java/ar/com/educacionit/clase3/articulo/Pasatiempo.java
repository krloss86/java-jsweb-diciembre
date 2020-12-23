package ar.com.educacionit.clase3.articulo;

public class Pasatiempo extends Articulo {

	private String marca;
	
	public Pasatiempo(Long id, String titulo, String autor, Float precio) {
		super(id, titulo, autor, precio);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
