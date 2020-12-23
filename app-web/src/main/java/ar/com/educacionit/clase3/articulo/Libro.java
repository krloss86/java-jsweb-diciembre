package ar.com.educacionit.clase3.articulo;

public class Libro extends Articulo {

	private String isbn;
	
	public Libro(Long id, String titulo, String autor, Float precio) {
		super(id, titulo, autor, precio);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
