package ar.com.educacionit.clase3.articulo;

public class Articulo {

	private Long id;
	private String titulo;
	private String autor;
	private Float precio;
	
	public Articulo(Long id, String titulo, String autor, Float precio) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public void informar() {		
		String informe = "{ titulo: " + this.titulo;
		informe = informe + " autor: " + this.autor;
		informe = informe + " precio: " + this.precio + "}";
		System.out.println(informe);
	}
	
	
}
