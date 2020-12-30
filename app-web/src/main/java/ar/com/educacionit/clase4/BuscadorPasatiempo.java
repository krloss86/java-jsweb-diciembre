package ar.com.educacionit.clase4;

import ar.com.educacionit.clase3.articulo.Articulo;
import ar.com.educacionit.clase3.articulo.Buscador;
import ar.com.educacionit.clase3.articulo.Libro;

public class BuscadorPasatiempo extends Buscador {

	public BuscadorPasatiempo(String claveBusqueda) {
		super(claveBusqueda);
	}

	public void buscar() {
		// select * from libro where titulo like '%this.claveBusqueda%' 
		String sql = "select * from pasatiempo where titulo like %" +  this.getClaveBusqueda() + "%";
		
		System.out.println("Ejecutando sql:" + sql);
		
		//contruyendo los resultados a partir de la consulta
		Libro articulo = new Libro(1L, "TONY STAR IRON MAN 01: UN...","SLOTT, DAN", 760f);
		articulo.setIsbn("123456789");
		
		this.setCantidadResultados(1);
		
		Articulo[] resultados = new Articulo[1];
		resultados[0] = articulo;
		
		this.resultados = resultados;
	}

}
