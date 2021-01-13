package ar.com.educacionit.domain;

public class Producto {

	private String titulo;
	private Long id;
	private Float precio;
	private String codigo;
	private Long tipoProducto;
	
	public Producto() {
	
	}

	public Producto(String titulo, Long id, Float precio, String codigo) {
		this.titulo = titulo;
		this.id = id;
		this.precio = precio;
		this.codigo = codigo;
	}
	
	public Producto(String titulo, Long id, Float precio, String codigo, Long tipoProducto) {
		this.titulo = titulo;
		this.id = id;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}
	
	public Producto(String titulo,Float precio, String codigo) {
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Producto [titulo=" + titulo + ", id=" + id + ", precio=" + precio + ", codigo=" + codigo
				+ ", tipoProducto=" + tipoProducto + "]";
	}

	public Long getTipoProducto() {
		if(tipoProducto == null) {
			tipoProducto = 1l;
		}
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	
}

