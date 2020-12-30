package ar.com.educacionit.clase3.articulo;

public class BuscadorPelicula extends Buscador {

	public BuscadorPelicula(String claveBusqueda) {
		super(claveBusqueda);
	}

	public void buscar() {
		// select * from libro where titulo like '%this.claveBusqueda%' 
		String sql = "select * from pelicula where titulo like %" +  this.getClaveBusqueda() + "%";
		
		System.out.println("Ejecutando sql:" + sql);
		
		//contruyendo los resultados a partir de la consulta
		Articulo articulo = new Pelicula(1L, "TONY STAR IRON MAN 01: UN...","SLOTT, DAN", 760f);
		
		Pelicula articuloP = (Pelicula)articulo;
		articuloP.setProductora("Fantasma");
		
		// ((Pelicula)articulo).setProductora("Fantasma");
		
		this.setCantidadResultados(1);
		
		Articulo[] resultados = new Articulo[1];
		resultados[0] = articulo;
		
		this.resultados = resultados;
	}

}
