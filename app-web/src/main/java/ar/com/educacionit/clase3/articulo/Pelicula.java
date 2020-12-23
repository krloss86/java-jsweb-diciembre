package ar.com.educacionit.clase3.articulo;

public class Pelicula extends Articulo {

	private String productora;
	
	//alt+shit+s
	public Pelicula(Long id, String titulo, String autor, Float precio) {
		super(id, titulo, autor, precio);
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}
	
}
