package ar.com.educacionit.clase3.articulo;

import ar.com.educacionit.clase4.BuscadorMusica;

public class BuscadroMain {

	public static void main(String[] args) {
		
		String claveBusquedaUsurio = "iron man";

		Buscador[] buscadores = new Buscador[2];
		
		//1 form
		Buscador buscadorLibro = new BuscadorMusica(claveBusquedaUsurio);
		buscadores[0] = buscadorLibro;
		
		//2 forma
		buscadores[1] = new BuscadorPelicula(claveBusquedaUsurio);
		
		//ejecutar todas las busquedas
		for(Buscador buscador : buscadores) {
			
			//magia del polimorfismo dinamic biniding!!!
			buscador.buscar();
			
			Articulo[] resultados = buscador.getResultados();
			
			buscador.informarCantidad();
			
			for(Articulo articulo : resultados) {
				
				articulo.informar();
			}
		}
	}

}
