package ar.com.educacionit.clase4;

import ar.com.educacionit.clase3.articulo.Articulo;
import ar.com.educacionit.clase3.articulo.Buscador;

public class BuscadorVacio extends Buscador {

	public BuscadorVacio(String claveBusqueda) {
		super(claveBusqueda);
	}

	public void buscar() {
		
		Articulo[] resultados = new Articulo[0];		
		this.resultados = resultados;
	}

}
