package ar.com.educacionit.clase3.articulo;

public abstract class Buscador {

	private String claveBusqueda;
	private int cantidadResultados;
	protected Articulo[] resultados;
	
	//metodo abstracto
	protected abstract void buscar();
	
	//buscar por id
	public Articulo buscarPorId(Long id) {
		//sql -> Articulo
		Articulo articulo = new Articulo(100L, "generico", "generico", 150f);
		return articulo;
	}
	
	
	public Buscador(String claveBusqueda) {
		this.claveBusqueda = claveBusqueda;
	}

	public String getClaveBusqueda() {
		return claveBusqueda;
	}

	public void setClaveBusqueda(String claveBusqueda) {
		this.claveBusqueda = claveBusqueda;
	}

	public int getCantidadResultados() {
		return cantidadResultados;
	}

	public void setCantidadResultados(int cantidadResultados) {
		this.cantidadResultados = cantidadResultados;
	}

	public Articulo[] getResultados() {
		return resultados;
	}

	public void informarCantidad() {
		System.out.println("Hemos Encontrado " + this.cantidadResultados + " Resultados Para '"+ this.claveBusqueda +"'");
	}
	
}
